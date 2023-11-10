package app.msgbot.di

import android.content.Context
import app.msgbot.network.service.GithubApiService
import de.jensklingenberg.ktorfit.Ktorfit
import de.jensklingenberg.ktorfit.ktorfit
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.android.ext.koin.androidContext
import org.koin.compose.koinInject
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val httpModule = module {
    fun provideHttpClient(context: Context, json: Json) = HttpClient(Android) {
        install(ContentNegotiation) {
            json(json)
        }
    }

    fun provideJson() = Json {
        encodeDefaults = true
        ignoreUnknownKeys = true
    }

    single {
        provideHttpClient(androidContext(), get())
    }
    singleOf(::provideJson)
}

val ktorfitModule = module {
    fun provideKtorfit(
        httpModule: HttpClient
    ) = ktorfit {
        baseUrl(GithubApiService.baseUrl)
        httpClient(httpModule)
    }

    single<Ktorfit> {
        provideKtorfit(get())
    }

    single<GithubApiService> {
        get<Ktorfit>().create()
    }
}
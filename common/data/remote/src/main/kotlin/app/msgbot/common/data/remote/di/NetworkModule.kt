package app.msgbot.common.data.remote.di

import android.content.Context
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.android.ext.koin.androidContext
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

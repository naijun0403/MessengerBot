package app.msgbot.feature.github.data.di

import app.msgbot.feature.github.data.repository.GithubRepositoryImpl
import app.msgbot.feature.github.domain.repository.GithubRepository
import org.koin.dsl.module

val githubModule = module {
    single {
        GithubRepositoryImpl(
            ioDispatcher = get()
        ) as GithubRepository
    }
}
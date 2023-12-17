package app.msgbot.feature.home.presentation.di

import app.msgbot.feature.home.presentation.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val homeViewModelMoudle = module {
    viewModelOf(::HomeViewModel)
}

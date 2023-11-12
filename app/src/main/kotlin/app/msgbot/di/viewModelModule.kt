package app.msgbot.di

import app.msgbot.viewmodel.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homeViewModel = module {
    viewModel<HomeViewModel> {
        HomeViewModel()
    }
}
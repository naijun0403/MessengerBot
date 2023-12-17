package app.msgbot.feature.home.presentation

import androidx.compose.runtime.Composable
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeRoute() {
    val viewModel = koinViewModel<HomeViewModel>()
}
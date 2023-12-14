package app.msgbot.feature.home.presentation

import androidx.compose.runtime.Composable
import app.msgbot.feature.home.presentation.destinations.HomeScreenDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination(start = true)
@Composable
fun HomeScreen(
    navigator: DestinationsNavigator
) {
    HomeScreenDestination
}
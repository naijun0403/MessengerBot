package app.msgbot.ui.pages

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import app.msgbot.ui.navigation.MessengerBotNavigationBar
import app.msgbot.ui.navigation.Route
import app.msgbot.ui.navigation.TopLevelDestination

@Composable
fun NavGraphView(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Route.HOME
    ) {
        composable(Route.HOME) {
            HomeLayout()
        }

        composable(Route.BOT_LIST) {
            BotListLayout()
        }

        composable(Route.SETTINGS) {
            EmptyComingSoonLayout() // TODO: SettingsLayout()
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainPageContent(
    selectedDestination: String,
    navigateToTopLevelDestination: (TopLevelDestination) -> Unit,
    navController: NavHostController
) {
    Scaffold(
        bottomBar = {
            MessengerBotNavigationBar(
                selectedDestination = selectedDestination,
                navigateToTopLevelDestination = navigateToTopLevelDestination
            )
        }
    ) {
        NavGraphView(navController = navController)
    }
}
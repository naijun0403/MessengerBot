package app.msgbot.ui.pages

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import app.msgbot.ui.navigation.MessengerBotNavigationBar
import app.msgbot.ui.navigation.Route
import app.msgbot.ui.navigation.TopLevelDestination

@Composable
fun NavGraphView(
    navController: NavHostController,
    padding: PaddingValues = PaddingValues(0.dp)
) {
    NavHost(
        navController = navController,
        startDestination = Route.HOME
    ) {
        composable(Route.HOME) {
            HomeLayout()
        }

        composable(Route.BOT_LIST) {
            BotListLayout(padding)
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
    navController: NavHostController,
) {
    Scaffold(
        bottomBar = {
            MessengerBotNavigationBar(
                selectedDestination = selectedDestination,
                navigateToTopLevelDestination = navigateToTopLevelDestination
            )
        },
    ) {
        NavGraphView(navController = navController, padding = it)
    }
}
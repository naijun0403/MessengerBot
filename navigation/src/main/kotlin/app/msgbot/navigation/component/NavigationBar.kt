package app.msgbot.navigation.component

import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import app.msgbot.navigation.util.LocalSnackbarHost

@Composable
fun NavigationBar(navController: NavController = rememberNavController()) {
    val snackbarHostState = SnackbarHostState()

    CompositionLocalProvider(value = LocalSnackbarHost provides snackbarHostState) {
        Scaffold {

        }
    }
}
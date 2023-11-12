package app.msgbot.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings

val TOP_LEVEL_DESTINATIONS = listOf(
    TopLevelDestination(
        route = Route.BOT_LIST,
        selectedIcon = Icons.Default.Menu,
        unselectedIcon = Icons.Default.Menu,
        title = "봇 목록"
    ),
    TopLevelDestination(
        route = Route.HOME,
        selectedIcon = Icons.Default.Home,
        unselectedIcon = Icons.Default.Home,
        title = "홈"
    ),
    TopLevelDestination(
        route = Route.SETTINGS,
        selectedIcon = Icons.Default.Settings,
        unselectedIcon = Icons.Default.Settings,
        title = "설정"
    )
)
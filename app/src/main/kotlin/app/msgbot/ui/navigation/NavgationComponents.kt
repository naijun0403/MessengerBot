package app.msgbot.ui.navigation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

// components라 하면서도, 이건 navigation에 대한 것이다.
// 따라서 navigation 패키지에 넣는다.

@Composable
fun MessengerBotNavigationBar(
    selectedDestination: String,
    navigateToTopLevelDestination: (TopLevelDestination) -> Unit,
) {
    NavigationBar(modifier = Modifier.fillMaxWidth()) {
        TOP_LEVEL_DESTINATIONS.forEach {
            NavigationBarItem(
                icon = {
                    if (it.route == selectedDestination) {
                        Icon(
                            imageVector = it.selectedIcon,
                            contentDescription = null,
                        )
                    } else {
                        Icon(
                            imageVector = it.unselectedIcon,
                            contentDescription = null,
                        ) // 이게 필요는 할까?
                    }
                },
                label = {
                    Text(text = it.title)
                },
                selected = it.route == selectedDestination,
                onClick = { navigateToTopLevelDestination(it) }
            )
        }
    }
}
package app.msgbot.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInVertically
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowDropDown
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun CreateBotExpandableCard(
    iconVector: ImageVector,
    title: String,
    content: @Composable () -> Unit,
) {
    var expandedState by remember { mutableStateOf(false) }

    val rotationState by animateFloatAsState(
        targetValue = if (expandedState) 180f else 0f, label = "",
    )

    ListItem(
        modifier = Modifier.run {
            animateContentSize(
                animationSpec = TweenSpec(
                    durationMillis = 300,
                    easing = LinearOutSlowInEasing
                )
            )
        },
        headlineContent = {
            Text(text = title)
        },
        leadingContent = {
            Icon(imageVector = iconVector, contentDescription = null)
        },
        trailingContent = {
            IconButton(
                modifier = Modifier.rotate(rotationState),
                onClick = {
                    expandedState = !expandedState
                },
            ) {
                Icon(
                    imageVector = Icons.Outlined.ArrowDropDown,
                    contentDescription = null,
                )
            }
        },
    )

    AnimatedVisibility(
        visible = expandedState,
        enter = slideInVertically(
            animationSpec = spring()
        ),
        exit = shrinkVertically()
    ) {
        content()
    }
}
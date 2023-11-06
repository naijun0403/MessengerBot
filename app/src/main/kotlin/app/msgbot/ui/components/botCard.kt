package app.msgbot.ui.components

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

/**
 * expandable card
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BotCard(
    name: String
) {
    var expandedState by remember { mutableStateOf(false) }

    val rotationState by animateFloatAsState(
        targetValue = if (expandedState) 180f else 0f, label = "",
    )

    Card(
        modifier = Modifier.run {
            width(350.dp)
                .animateContentSize(
                    animationSpec = TweenSpec(
                        durationMillis = 300,
                        easing = LinearOutSlowInEasing
                    )
                )
                .padding(top = 30.dp, start = 10.dp, end = 10.dp, bottom = 10.dp)
        },
        onClick = {
            expandedState = !expandedState
        },
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.onPrimary
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    modifier = Modifier.weight(6f),
                    text = "테스트 타이틀",
                    fontSize = MaterialTheme.typography.titleLarge.fontSize,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                
                IconButton(
                    modifier = Modifier
                        .weight(1f)
                        .rotate(rotationState),
                    onClick = {
                        expandedState = !expandedState
                    }
                ) {
                    Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = "")
                }
            }
        }

        if (expandedState) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
            ) {
                Icon(imageVector = Icons.Default.Edit, contentDescription = "edit")
            }
        }
    }

}
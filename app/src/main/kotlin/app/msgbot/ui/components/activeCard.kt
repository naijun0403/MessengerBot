package app.msgbot.ui.components

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * 봇을 활성화할지 여부를 설정하는 카드
 */
@Composable
fun ActiveCard() {
    Card(
        modifier = Modifier
            .width(350.dp)
            .height(100.dp)
            .padding(top = 30.dp, start = 10.dp, end = 10.dp, bottom = 10.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Text(
                text = "모든 봇 활성화",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(top = 13.dp, start = 20.dp),
                color = if (isSystemInDarkTheme()) MaterialTheme.colorScheme.onSurface else MaterialTheme.colorScheme.onSurfaceVariant
            )
        }

        Row(
            modifier = Modifier
                .requiredHeight(45.dp)
                .fillMaxWidth()
                .padding(end = 20.dp, bottom = 45.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
        ) {
            Switch(
                checked = true,
                onCheckedChange = {},
            )
        }
    }
}
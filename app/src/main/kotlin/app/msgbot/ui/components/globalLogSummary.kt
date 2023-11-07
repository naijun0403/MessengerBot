package app.msgbot.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import app.msgbot.ui.font.NotoSansKrRegular

/**
 * TODO: 글로벌 로그 요약 (내용 미구현)
 */
@Composable
fun GlobalLogSummary() {
    Card(
        modifier = Modifier
            .width(330.dp)
            .height(250.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        )
    ) {
        Column(
            modifier = Modifier
                .padding(start = 20.dp, top = 15.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            Text(text = "글로벌 로그", style = MaterialTheme.typography.titleLarge, fontFamily = NotoSansKrRegular)
        }

        Column(
            modifier = Modifier
                .padding(start = 20.dp, top = 15.dp, end = 20.dp, bottom = 15.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                modifier = Modifier
                    .width(330.dp)
                    .height(130.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.inverseOnSurface,
                )
            ) {
                // TODO: 글로벌 로그 요약 내용
            }
        }

        // detail button
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, top = 15.dp, end = 20.dp, bottom = 15.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.End
        ) {
            Button(
                modifier = Modifier.requiredHeight(54.dp)
                    .padding(bottom = 14.dp),
                onClick = { /* TODO */ }
            ) {
                Text(text = "자세히 보기", fontFamily = NotoSansKrRegular)
            }
        }
    }
}
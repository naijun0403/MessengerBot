package app.msgbot.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Error
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * 최신 버전인지 여부를 표시하는 카드
 * @param isLatestVersion 최신 버전인지 여부
 * @see app.msgbot.ui.pages.HomeLayout
 */
@Composable
fun RecentVersionCard(
    isLatestVersion: Boolean = true,
) {
    val color = if (isLatestVersion) {
        CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.onPrimary
        )
    } else {
        CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.error,
            contentColor = MaterialTheme.colorScheme.onError
        )
    }

    Card(
        modifier = Modifier
            .width(350.dp)
            .height(150.dp)
            .padding(top = 30.dp, start = 10.dp, end = 10.dp, bottom = 10.dp),
        colors = color
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
                    .padding(start = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                if (isLatestVersion) {
                    Image(
                        imageVector = Icons.Default.CheckCircle,
                        contentDescription = null,
                        modifier = Modifier.size(25.dp),
                        colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onPrimary)
                    )
                } else {
                    Image(
                        imageVector = Icons.Default.Error,
                        contentDescription = null,
                        modifier = Modifier.size(25.dp),
                        colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onError)
                    )
                }

                Spacer(modifier = Modifier.padding(10.dp))

                if (isLatestVersion) {
                    Column {
                        Text(text = "최신 버전입니다.", fontSize = 18.sp)

                        Spacer(modifier = Modifier.padding(1.dp))

                        Text(text = "현재 버전 정보: 1.0")
                    }
                } else {
                    Column {
                        Text(text = "최신 버전이 아닙니다.", fontSize = 18.sp)

                        Spacer(modifier = Modifier.padding(1.dp))

                        Text(text = "현재 버전 정보: 1.0")
                    }
                }
            }
        }
    }
}
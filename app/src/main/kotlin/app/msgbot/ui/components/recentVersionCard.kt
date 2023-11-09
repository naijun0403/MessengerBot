package app.msgbot.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Error
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import app.msgbot.ui.font.SpoqaHanSansNeoRegular

/**
 * 최신 버전인지 여부를 표시하는 카드
 * @param isLatestVersion 최신 버전인지 여부
 * @see app.msgbot.ui.pages.HomeLayout
 */
@Composable
fun RecentVersionCard(
    isLatestVersion: Boolean = true,
    onExit: () -> Unit
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
            .width(330.dp)
            .height(100.dp),
        colors = color
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
        ) {
            // status icon
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(start = 20.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                Image(
                    imageVector = if (isLatestVersion) Icons.Default.CheckCircle else Icons.Default.Error,
                    contentDescription = null,
                    colorFilter = if (isLatestVersion) ColorFilter.tint(MaterialTheme.colorScheme.onPrimary) else ColorFilter.tint(
                        MaterialTheme.colorScheme.onError
                    ),
                    modifier = Modifier
                        .size(30.dp)
                )
            }

            // status text
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(top = 10.dp)
            ) {
                Text(
                    text = if (isLatestVersion) "최신버전입니다" else "최신버전이 아닙니다",
                    style = MaterialTheme.typography.titleMedium,
                    fontFamily = SpoqaHanSansNeoRegular,
                    color = if (isLatestVersion) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onError,
                    modifier = Modifier
                        .padding(start = 20.dp, top = 16.dp)
                )

                Column(
                    modifier = Modifier.requiredHeight(100.dp),
                    verticalArrangement = Arrangement.Bottom,
                ) {
                    Text(
                        text = if (isLatestVersion) "현재 버전: 1.0.0" else "최신 버전: 1.0.1",
                        style = MaterialTheme.typography.bodyMedium,
                        fontFamily = SpoqaHanSansNeoRegular,
                        color = if (isLatestVersion) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onError,
                        modifier = Modifier
                            .padding(start = 20.dp, bottom = 50.dp)
                    )
                }
            }

            // close button
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 15.dp, end = 20.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.End
            ) {
                IconButton(
                    onClick = {
                        onExit()
                    },
                    modifier = Modifier
                        .size(20.dp),
                ) {
                    Image(
                        imageVector = Icons.Default.Close,
                        contentDescription = null,
                        colorFilter = if (isLatestVersion) ColorFilter.tint(MaterialTheme.colorScheme.onPrimary) else ColorFilter.tint(
                            MaterialTheme.colorScheme.onError
                        ),
                        modifier = Modifier
                            .size(20.dp)
                    )
                }
            }
        }
    }
}
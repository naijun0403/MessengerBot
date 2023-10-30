package app.msgbot.ui.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeLayout() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "메신저봇",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(top = 70.dp)
        ) // title

        AllEnabledCard()

        Spacer(modifier = Modifier.padding(10.dp))

        RecentVersionCard()
    }
}

@Composable
fun AllEnabledCard() {
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

/**
 * TODO: 최신버전이 아니면 에러 메시지를 보여주어야 함 (일단 무조건 최신버전으로 가정)
 */
@Composable
fun RecentVersionCard() {
    Card(
        modifier = Modifier
            .size(
                width = 330.dp,
                height = 110.dp
            ),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.onPrimary
        )
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
                Image(
                    imageVector = Icons.Default.CheckCircle,
                    contentDescription = "check",
                    modifier = Modifier.size(25.dp),
                    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onPrimary)
                )

                Spacer(modifier = Modifier.padding(10.dp))

                Column {
                    Text(text = "최신 버전입니다.", fontSize = 18.sp)

                    Spacer(modifier = Modifier.padding(1.dp))

                    Text(text = "현재 버전 정보: 1.0")
                }
            }
        }
    }
}
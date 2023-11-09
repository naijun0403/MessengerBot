package app.msgbot.ui.pages

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.scaleOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import app.msgbot.ui.components.ActiveCard
import app.msgbot.ui.components.GlobalLogSummary
import app.msgbot.ui.components.NeedUpdateCard
import app.msgbot.ui.components.RecentVersionCard
import app.msgbot.ui.font.D2CodingRegular
import app.msgbot.ui.font.SpoqaHanSansNeoRegular

@Composable
fun HomeLayout() {
    var isLatestVersion = false // TODO: 최신버전인지 확인 (debug)

    var scrollState = rememberScrollState()

    var visible by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 20.dp, start = 15.dp, end = 15.dp)
            .verticalScroll(scrollState),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "메신저봇",
            style = MaterialTheme.typography.headlineLarge,
            fontFamily = SpoqaHanSansNeoRegular,
            modifier = Modifier.padding(top = 70.dp)
        ) // title

        Spacer(modifier = Modifier.height(20.dp))

        ActiveCard()

        Spacer(modifier = Modifier.height(20.dp))

        AnimatedVisibility(
            visible = visible,
            exit = shrinkVertically()
        ) {
            Box(
                modifier = Modifier.padding(bottom = 20.dp)
            ) {
                RecentVersionCard(isLatestVersion, onExit = {
                    visible = false
                })
            }
        }

        if (!isLatestVersion) {
            NeedUpdateCard(
                downloadURL = "https://github.com/naijun0403/MessengerBot/releases"
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        GlobalLogSummary()

        Spacer(modifier = Modifier.height(20.dp))
    }
}
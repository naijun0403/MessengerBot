package app.msgbot.ui.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import app.msgbot.ui.components.ActiveCard
import app.msgbot.ui.components.GlobalLogSummary
import app.msgbot.ui.components.NeedUpdateCard
import app.msgbot.ui.components.RecentVersionCard
import app.msgbot.ui.font.NotoSansKrRegular

@Composable
fun HomeLayout() {
    var isLatestVersion = false // TODO: 최신버전인지 확인 (debug)

    var scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 20.dp, start = 15.dp, end = 15.dp)
            .verticalScroll(scrollState),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "메신저봇",
            style = MaterialTheme.typography.headlineLarge,
            fontFamily = NotoSansKrRegular,
            modifier = Modifier.padding(top = 70.dp)
        ) // title
        
        Spacer(modifier = Modifier.padding(10.dp))

        ActiveCard()

        RecentVersionCard(isLatestVersion)

        if (!isLatestVersion) {
            NeedUpdateCard()
        }

        GlobalLogSummary()
    }
}
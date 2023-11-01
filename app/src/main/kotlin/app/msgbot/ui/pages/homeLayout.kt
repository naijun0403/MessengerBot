package app.msgbot.ui.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import app.msgbot.ui.components.ActiveCard
import app.msgbot.ui.components.GlobalLogSummary
import app.msgbot.ui.components.RecentVersionCard

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

        ActiveCard()

        Spacer(modifier = Modifier.padding(10.dp))

        RecentVersionCard()

        GlobalLogSummary()
    }
}
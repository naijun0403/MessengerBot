package app.msgbot.ui.pages

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import app.msgbot.ui.components.BotCard

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun BotListLayout(
    rootScaffoldPaddingValues: PaddingValues = PaddingValues(0.dp),
) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {}, shape = CircleShape) {
                Icon(Icons.Filled.Add, "Floating Action Button")
            }
        },
        modifier = Modifier.padding(rootScaffoldPaddingValues)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 20.dp, start = 20.dp, end = 20.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "메신저봇",
                style = MaterialTheme.typography.headlineLarge,
                modifier = Modifier.padding(top = 70.dp)
            ) // title

            BotCard(name = "sd")
        }
    }
}
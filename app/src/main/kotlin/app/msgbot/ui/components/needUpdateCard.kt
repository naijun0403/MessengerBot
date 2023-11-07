package app.msgbot.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.msgbot.ui.font.NotoSansKrRegular

@Composable
fun NeedUpdateCard(
    downloadURL: String = "",
) {
    val uriHandler = LocalUriHandler.current

    Card(
        modifier = Modifier
            .width(330.dp)
            .height(150.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 20.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            Text(text = "업데이트가 필요합니다", style = MaterialTheme.typography.titleLarge, fontFamily = NotoSansKrRegular)

            Text(text = "최신버전으로 업데이트 해주세요", style = MaterialTheme.typography.bodyMedium, fontFamily = NotoSansKrRegular, modifier = Modifier.padding(bottom = 20.dp))
        }

//        Column(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(start = 20.dp, top = 20.dp, end = 20.dp, bottom = 15.dp),
//            verticalArrangement = Arrangement.Bottom,
//            horizontalAlignment = Alignment.End
//        ) {
//            Button(
//                onClick = {
//                    uriHandler.openUri(downloadURL)
//                },
//                modifier = Modifier
//                    .requiredHeight(50.dp)
//            ) {
//                Text(text = "업데이트", fontFamily = NotoSansKrRegular)
//            }
//        }
    }
}
package app.msgbot.ui.utils

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun TodoAlert(onDismissRequest: () -> Unit) {
    AlertDialog(
        onDismissRequest = onDismissRequest,
        title = {
            Text(text = "경고")
        },
        text = {
            Text(text = """
                    이 기능은 아직 구현되지 않았습니다.
                """.trimIndent())
        },
        confirmButton = {
            Button(onClick = {
                onDismissRequest()
            }) {
                Text(text = "확인")
            }
        },
    )
}
package app.msgbot.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccessibilityNew
import androidx.compose.material.icons.outlined.Architecture
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material.icons.outlined.Javascript
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.FilterChip
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import app.msgbot.model.ApiModel
import app.msgbot.model.EngineModel
import app.msgbot.model.LanguageModel
import app.msgbot.ui.utils.TodoAlert

val SELECTABLE_LANGUAGE = listOf(
    LanguageModel(
        id = "JS",
        name = "JavaScript",
    ),
    LanguageModel(
        id = "TS",
        name = "TypeScript",
    ),
)

val SELECTABLE_ENGINE = listOf(
    EngineModel(
        id = "graaljs",
        name = "GraalJS",
    ),
    EngineModel(
        id = "v8",
        name = "V8",
    ),
)

val SELECTABLE_API = listOf(
    ApiModel(
        id = "kapi",
        name = "kapi",
        deprecated = false,
    ),
    ApiModel(
        id = "api2",
        name = "api2",
        deprecated = false,
    ),
    ApiModel(
        id = "legacy",
        name = "legacyAPI",
        deprecated = true,
    )
)

@Composable
fun CreateBotProject() {
    var botName by remember { mutableStateOf("") }
    var languageSelected by remember { mutableStateOf(SELECTABLE_LANGUAGE.first().id) }
    var engineSelected by remember { mutableStateOf(SELECTABLE_ENGINE.first().id) }
    var apiSelected by remember { mutableStateOf(SELECTABLE_API.first().id) }

    var deprecatedAlertVisible by remember { mutableStateOf(false) }
    var todoAlertVisible by remember { mutableStateOf(false) }

    if (deprecatedAlertVisible) {
        AlertDialog(
            onDismissRequest = {
                deprecatedAlertVisible = false
            },
            title = {
                Text(text = "경고")
            },
            text = {
                Text(text = """
                    이 API는 더 이상 지원되지 않습니다.
                    
                    따라서 최소한의 기능만 지원하며, 이 API를 사용하는 것을 권장하지 않습니다.
                """.trimIndent())
            },
            confirmButton = {
                Button(onClick = {
                    deprecatedAlertVisible = false
                }) {
                    Text(text = "확인")
                }
            },
        )
    }

    if (todoAlertVisible) {
        TodoAlert {
            todoAlertVisible = false
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 20.dp, end = 20.dp),
        horizontalAlignment = Alignment.Start,
    ) {
        // text field for bot name
        OutlinedTextField(
            value = botName,
            onValueChange = { botName = it },
            modifier = Modifier
                .fillMaxWidth(),
            label = {
                Text(text = "봇 이름")
            },
        )

        CreateBotExpandableCard(iconVector = Icons.Outlined.Javascript, title = "언어 설정") {
            Row {
                SELECTABLE_LANGUAGE.forEach { language ->
                    FilterChip(
                        onClick = {
                            languageSelected = language.id
                        },
                        label = {
                            Text(
                                text = language.name,
                            )
                        },
                        selected = languageSelected == language.id,
                        leadingIcon = if (languageSelected == language.id) {
                            {
                                Icon(
                                    imageVector = Icons.Outlined.Check,
                                    contentDescription = null,
                                )
                            }
                        } else null
                    )

                    if (language != SELECTABLE_LANGUAGE.last()) {
                        Spacer(modifier = Modifier.padding(end = 10.dp))
                    }
                }
            }
        }

        HorizontalDivider()

        CreateBotExpandableCard(iconVector = Icons.Outlined.Architecture, title = "엔진 설정") {
            Row {
                SELECTABLE_ENGINE.forEach { engine ->
                    FilterChip(
                        onClick = {
                            engineSelected = engine.id
                        },
                        label = {
                            Text(
                                text = engine.name,
                            )
                        },
                        selected = engineSelected == engine.id,
                        leadingIcon = if (engineSelected == engine.id) {
                            {
                                Icon(
                                    imageVector = Icons.Outlined.Check,
                                    contentDescription = null,
                                )
                            }
                        } else null
                    )

                    if (engine != SELECTABLE_ENGINE.last()) {
                        Spacer(modifier = Modifier.padding(end = 10.dp))
                    }
                }
            }
        }

        HorizontalDivider()

        CreateBotExpandableCard(iconVector = Icons.Outlined.AccessibilityNew, title = "api 설정") {
            Row {
                SELECTABLE_API.forEach { api ->
                    FilterChip(
                        onClick = {
                            apiSelected = api.id

                            if (api.deprecated) {
                                deprecatedAlertVisible = true
                            }
                        },
                        label = {
                            Text(
                                text = api.name,
                            )
                        },
                        selected = apiSelected == api.id,
                        leadingIcon = if (apiSelected == api.id) {
                            {
                                Icon(
                                    imageVector = Icons.Outlined.Check,
                                    contentDescription = null,
                                )
                            }
                        } else null
                    )

                    if (api != SELECTABLE_API.last()) {
                        Spacer(modifier = Modifier.padding(end = 10.dp))
                    }
                }
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
        ) {
            Button(
                onClick = {
                    todoAlertVisible = true
                }
            ) {
                Text(text = "생성")
            }
        }
    }
}

@Composable
fun CreateBotTitle(iconVector: ImageVector, title: String) {
    Row {
        Icon(
            imageVector = iconVector,
            contentDescription = null,
            modifier = Modifier
                .padding(end = 10.dp),
        )

        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium,
        )
    }
}
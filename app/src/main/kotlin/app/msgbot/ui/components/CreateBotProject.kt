package app.msgbot.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Architecture
import androidx.compose.material.icons.outlined.Badge
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material.icons.outlined.Javascript
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
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
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import app.msgbot.model.EngineModel
import app.msgbot.model.LanguageModel

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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateBotProject() {
    var languageSelected by remember { mutableStateOf(SELECTABLE_LANGUAGE.first().id) }
    var engineSelected by remember { mutableStateOf(SELECTABLE_ENGINE.first().id) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 20.dp, end = 20.dp),
        horizontalAlignment = Alignment.Start,
    ) {
        // text field for bot name
        OutlinedTextField(
            value = "",
            onValueChange = {},
            modifier = Modifier
                .fillMaxWidth()
                .scale(scaleY = 0.9f, scaleX = 1f),
            label = {
                Text(text = "봇 이름")
            },
        )

        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp, bottom = 20.dp),
        )

        CreateBotTitle(
            iconVector = Icons.Outlined.Javascript,
            title = "언어 설정",
        )

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

        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp, bottom = 20.dp),
        )

        CreateBotTitle(
            iconVector = Icons.Outlined.Architecture,
            title = "엔진 설정",
        )

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

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
        ) {
            Button(onClick = {}) {
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
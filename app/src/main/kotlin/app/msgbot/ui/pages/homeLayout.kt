package app.msgbot.ui.pages

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.VisibilityThreshold
import androidx.compose.animation.core.spring
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInVertically
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
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import app.msgbot.ui.components.ActiveCard
import app.msgbot.ui.components.GlobalLogSummary
import app.msgbot.ui.components.NeedUpdateCard
import app.msgbot.ui.components.RecentVersionCard
import app.msgbot.ui.font.SpoqaHanSansNeoRegular
import app.msgbot.viewmodel.HomeViewModel
import app.msgbot.viewmodel.HomeViewModelFactory

@Composable
fun HomeLayout() {
    val viewModel: HomeViewModel = viewModel(factory = HomeViewModelFactory())

    var isLatestVersion = false
    val isLoadedVersion = rememberSaveable { mutableStateOf(false) }
    val loadedVersionState: MutableState<HomeViewModel.VersionLoadState> =
        remember { mutableStateOf(HomeViewModel.VersionLoadState.Loading) }


    var noticeVersionCardVisible by rememberSaveable { mutableStateOf(false) }
    var needVersionCardVisible by rememberSaveable { mutableStateOf(false) }

    if (!isLoadedVersion.value) {
        when (val data = viewModel.state.collectAsState().value) {
            HomeViewModel.VersionLoadState.Loading -> {
                // maybe all value is false
            }

            is HomeViewModel.VersionLoadState.Success -> {
                isLatestVersion = true
                noticeVersionCardVisible = true

                loadedVersionState.value = data
                isLoadedVersion.value = true

            }

            is HomeViewModel.VersionLoadState.Error -> {
                isLatestVersion = false
                noticeVersionCardVisible = true
                needVersionCardVisible = true

                loadedVersionState.value = data
                isLoadedVersion.value = true

            }
        }
    }

    val scrollState = rememberScrollState()

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
            visible = noticeVersionCardVisible,
            enter = slideInVertically(
                animationSpec = spring(
                    stiffness = Spring.StiffnessVeryLow,
                    visibilityThreshold = IntOffset.VisibilityThreshold
                )
            ),
            exit = shrinkVertically()
        ) {
            Box(
                modifier = Modifier.padding(bottom = 20.dp)
            ) {
                RecentVersionCard(isLatestVersion, onExit = {
                    noticeVersionCardVisible = false
                })
            }
        }

        AnimatedVisibility(
            visible = needVersionCardVisible,
            enter = slideInVertically(
                animationSpec = spring(
                    stiffness = Spring.StiffnessVeryLow,
                    visibilityThreshold = IntOffset.VisibilityThreshold
                )
            ),
            exit = shrinkVertically()
        ) {
            Box(
                modifier = Modifier.padding(bottom = 20.dp)
            ) {
                NeedUpdateCard(
                    downloadURL = "https://github.com/naijun0403/MessengerBot/releases",
                    enabled = true,
                )
            }
        }

        GlobalLogSummary()

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "메신저봇은 메신저봇R의 공식 앱이 아닙니다.",
            style = MaterialTheme.typography.bodyMedium,
            fontFamily = SpoqaHanSansNeoRegular,
            modifier = Modifier.padding(bottom = 20.dp)
        )
    }
}
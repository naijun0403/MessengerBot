package app.msgbot.feature.home.presentation

import androidx.lifecycle.ViewModel
import app.msgbot.feature.home.presentation.state.VersionLoadingState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class HomeViewModel : ViewModel() {
    private val _versionLoadingState = MutableStateFlow<VersionLoadingState>(VersionLoadingState.Loading)
    val versionLoadingState: StateFlow<VersionLoadingState> = _versionLoadingState
}
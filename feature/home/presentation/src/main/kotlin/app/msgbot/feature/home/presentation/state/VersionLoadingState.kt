package app.msgbot.feature.home.presentation.state

sealed class VersionLoadingState {
    data class Success(val version: String) : VersionLoadingState()
    data class Error(val message: String) : VersionLoadingState()
    data object Loading : VersionLoadingState()
}
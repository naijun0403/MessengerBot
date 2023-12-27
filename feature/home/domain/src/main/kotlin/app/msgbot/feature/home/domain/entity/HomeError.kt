package app.msgbot.feature.home.domain.entity

sealed class HomeError {
    data object IsRecentVersionError : HomeError()
    data class UnknownError(val throwable: Throwable) : HomeError()
}
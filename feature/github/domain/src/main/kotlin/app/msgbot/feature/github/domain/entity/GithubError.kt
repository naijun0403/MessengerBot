package app.msgbot.feature.github.domain.entity

sealed class GithubError {
    data object NetworkError : GithubError()
    data class UnknownError(val throwable: Throwable) : GithubError()
    data class ServerError(val code: Int, val message: String) : GithubError()
}
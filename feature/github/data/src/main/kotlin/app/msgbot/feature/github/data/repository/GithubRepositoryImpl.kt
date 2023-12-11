package app.msgbot.feature.github.data.repository

import app.msgbot.core.FlowResult
import app.msgbot.core.Result
import app.msgbot.feature.github.data.mapper.toDomain
import app.msgbot.feature.github.data.service.GithubApiService
import app.msgbot.feature.github.domain.entity.GithubError
import app.msgbot.feature.github.domain.entity.GithubReleaseEntity
import app.msgbot.feature.github.domain.repository.GithubRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart

class GithubRepositoryImpl(
    private val githubApiService: GithubApiService,
    private val ioDispatcher: CoroutineDispatcher
) : GithubRepository {
    override fun getLatestRelease(): FlowResult<GithubReleaseEntity, GithubError> = flow<Result<GithubReleaseEntity, GithubError>> {
        try {
            val release = githubApiService.getLatestRelease()
            emit(Result.Success(release.toDomain()))
        } catch (e: Exception) {
            emit(Result.Error(GithubError.UnknownError(e)))
        }
    }.onStart { emit(Result.Loading()) }.catch {
        emit(Result.Error(GithubError.NetworkError))
    }.flowOn(ioDispatcher)
}
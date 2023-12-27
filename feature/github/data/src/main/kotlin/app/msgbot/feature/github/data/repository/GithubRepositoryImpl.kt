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
    private val ioDispatcher: CoroutineDispatcher
) : GithubRepository {
    private val githubApiService by lazy { GithubApiService() }

    override fun getLatestRelease(): FlowResult<GithubReleaseEntity, GithubError> = flow<Result<GithubReleaseEntity, GithubError>> {
        val release = githubApiService.getLatestRelease()
        emit(Result.Success(release.toDomain()))
    }.onStart {
        emit(Result.Loading())
    }.catch {
        emit(Result.Error(GithubError.UnknownError(it)))
    }.flowOn(ioDispatcher)
}
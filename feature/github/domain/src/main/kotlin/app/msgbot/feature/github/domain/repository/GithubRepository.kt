package app.msgbot.feature.github.domain.repository

import app.msgbot.core.FlowResult
import app.msgbot.feature.github.domain.entity.GithubError
import app.msgbot.feature.github.domain.entity.GithubReleaseEntity

interface GithubRepository {
    fun getLatestRelease(): FlowResult<GithubReleaseEntity, GithubError>
}
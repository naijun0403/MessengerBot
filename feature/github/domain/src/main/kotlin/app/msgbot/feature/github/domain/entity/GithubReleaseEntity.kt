package app.msgbot.feature.github.domain.entity

import java.net.URL
import java.util.Date

data class GithubReleaseEntity(
    val url: URL,
    val assetsUrl: String,
    val uploadUrl: String,
    val htmlUrl: URL,
    val id: Long,
    val nodeId: String,
    val tagName: String,
    val targetCommitish: String,
    val name: String,
    val draft: Boolean,
    val preRelease: Boolean,
    val createdAt: Date,
    val publishedAt: Date,
    val assets: List<GithubAssetEntity>,
)

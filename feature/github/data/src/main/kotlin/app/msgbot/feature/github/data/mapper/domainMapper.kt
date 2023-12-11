package app.msgbot.feature.github.data.mapper

import app.msgbot.feature.github.domain.entity.GithubAssetEntity
import app.msgbot.feature.github.domain.entity.GithubReleaseEntity
import org.kohsuke.github.GHAsset
import org.kohsuke.github.GHRelease

fun GHRelease.toDomain() = GithubReleaseEntity(
    url = url,
    assetsUrl = assetsUrl,
    uploadUrl = uploadUrl,
    htmlUrl = htmlUrl,
    id = id,
    nodeId = nodeId,
    tagName = tagName,
    targetCommitish = targetCommitish,
    name = name,
    draft = isDraft,
    preRelease = isPrerelease,
    createdAt = createdAt,
    publishedAt = published_at,
    assets = listAssets().map { it.toDomain() }
)

fun GHAsset.toDomain() = GithubAssetEntity(
    url = url,
    id = id,
    nodeId = nodeId,
    name = name,
    label = label,
    state = state,
    contentType = contentType,
    size = size,
    downloadCount = downloadCount,
    createdAt = createdAt,
    updatedAt = updatedAt,
    browserDownloadUrl = browserDownloadUrl
)
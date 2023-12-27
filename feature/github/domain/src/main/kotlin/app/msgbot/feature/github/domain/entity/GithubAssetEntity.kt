package app.msgbot.feature.github.domain.entity

import java.net.URL
import java.util.Date

data class GithubAssetEntity(
    val url: URL,
    val id: Long,
    val nodeId: String,
    val name: String,
    val label: String,
    val contentType: String,
    val state: String,
    val size: Long,
    val downloadCount: Long,
    val createdAt: Date,
    val updatedAt: Date,
    val browserDownloadUrl: String,
)

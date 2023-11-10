package app.msgbot.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

@Serializable
data class GithubReleaseModel(
    val url: String,

    @SerialName("assets_url")
    val assetsUrl: String,

    @SerialName("upload_url")
    val uploadUrl: String,

    @SerialName("html_url")
    val htmlUrl: String,

    val id: Int,

    val author: JsonObject, // author를 안쓰는 지금 구현할 필요는 없을 듯

    @SerialName("node_id")
    val nodeId: String,

    @SerialName("tag_name")
    val tagName: String,

    @SerialName("target_commitish")
    val targetCommitish: String,

    val name: String,

    val draft: Boolean,

    @SerialName("prerelease")
    val preRelease: Boolean,

    @SerialName("created_at")
    val createdAt: String,

    @SerialName("published_at")
    val publishedAt: String,

    val assets: List<GithubAssetModel>,
)

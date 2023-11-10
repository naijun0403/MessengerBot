package app.msgbot.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

@Serializable
data class GithubAssetModel(
    val url: String,

    val id: Int,

    @SerialName("node_id")
    val nodeId: String,

    val name: String,

    val label: String? = null,

    val uploader: JsonObject,

    @SerialName("content_type")
    val contentType: String,

    val state: String,

    val size: Int,

    @SerialName("download_count")
    val downloadCount: Int,

    @SerialName("created_at")
    val createdAt: String,

    @SerialName("updated_at")
    val updatedAt: String,

    @SerialName("browser_download_url")
    val browserDownloadUrl: String
)

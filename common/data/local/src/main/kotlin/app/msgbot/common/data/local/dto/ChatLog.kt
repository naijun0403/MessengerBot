package app.msgbot.common.data.local.dto

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "chat_logs")
data class ChatLog(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,

    @ColumnInfo(name = "project_id")
    val projectId: Int,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "message")
    val message: String,

    @ColumnInfo(name = "is_bot")
    val isBot: Boolean,

    @ColumnInfo(name = "profile_hash")
    val profileHash: String,

    @ColumnInfo(name = "channel_id")
    val channelId: Long,
)

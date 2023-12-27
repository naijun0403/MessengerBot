package app.msgbot.common.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import app.msgbot.common.data.local.dao.ChatLogDao
import app.msgbot.common.data.local.dto.ChatLog

@Database(
    entities = [
        ChatLog::class,
    ],
    version = 1,
    exportSchema = false
)
abstract class ChatDatabase : RoomDatabase() {
    abstract fun chatLogDao(): ChatLogDao
}
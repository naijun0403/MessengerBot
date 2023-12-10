package app.msgbot.common.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import app.msgbot.common.data.local.dto.ChatLog

@Dao
interface ChatLogDao {

    @Query("SELECT * FROM chat_logs")
    suspend fun getAllChatLogs(): List<ChatLog>

    @Query("SELECT * FROM chat_logs WHERE project_id = :projectId")
    suspend fun getChatLogsByProjectId(projectId: Int): List<ChatLog>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertChatLog(chatLog: ChatLog)

    @Delete
    suspend fun deleteChatLog(chatLog: ChatLog)

    @Update
    suspend fun updateChatLog(chatLog: ChatLog)

}
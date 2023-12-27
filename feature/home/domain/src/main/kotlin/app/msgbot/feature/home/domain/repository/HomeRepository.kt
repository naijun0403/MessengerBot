package app.msgbot.feature.home.domain.repository

import app.msgbot.core.FlowResult
import app.msgbot.feature.home.domain.entity.HomeError

interface HomeRepository {
    fun isRecentVersion(): FlowResult<Boolean, HomeError>
}
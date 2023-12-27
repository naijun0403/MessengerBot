package app.msgbot.feature.home.domain.usecase

import app.msgbot.feature.home.domain.repository.HomeRepository

class GetIsRecentVersionUseCase(
    private val homeRepository: HomeRepository
) {
}
package com.andreykosarygin.game_domain.usecases

import com.andreykosarygin.common.PointsBalance
import com.andreykosarygin.game_domain.Repository

class SavePointsBalanceUseCase(
    private val repository: Repository
) {
    suspend fun execute(pointsBalance: PointsBalance): Boolean = repository.savePointsBalanceToAppData(pointsBalance)
}
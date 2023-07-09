package com.andreykosarygin.game_domain.usecases

import com.andreykosarygin.common.PointsBalance
import com.andreykosarygin.game_domain.Repository

class GetPointsBalanceUseCase(
    private val repository: Repository
) {
    suspend fun execute(): PointsBalance = repository.getPointsBalanceFromAppData()
}
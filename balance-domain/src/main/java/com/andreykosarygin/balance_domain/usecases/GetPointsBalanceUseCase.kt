package com.andreykosarygin.balance_domain.usecases

import com.andreykosarygin.balance_domain.Repository
import com.andreykosarygin.common.PointsBalance

class GetPointsBalanceUseCase(
    private val repository: Repository
) {
    suspend fun execute(): PointsBalance = repository.getPointsBalanceFromAppData()
}
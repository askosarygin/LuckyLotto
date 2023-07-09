package com.andreykosarygin.balance_domain

import com.andreykosarygin.balance_domain.usecases.GetPointsBalanceUseCase
import com.andreykosarygin.common.PointsBalance

class InteractorImpl(
    private val getPointsBalanceUseCase: GetPointsBalanceUseCase
) : Interactor {
    override suspend fun getPointsBalance(): PointsBalance = getPointsBalanceUseCase.execute()
}
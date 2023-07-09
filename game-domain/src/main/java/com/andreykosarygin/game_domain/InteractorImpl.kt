package com.andreykosarygin.game_domain

import com.andreykosarygin.common.PointsBalance
import com.andreykosarygin.game_domain.usecases.GetPointsBalanceUseCase
import com.andreykosarygin.game_domain.usecases.SavePointsBalanceUseCase

class InteractorImpl(
    private val getPointsBalanceUseCase: GetPointsBalanceUseCase,
    private val savePointsBalanceUseCase: SavePointsBalanceUseCase
) : Interactor {
    override suspend fun getPointsBalance(): PointsBalance = getPointsBalanceUseCase.execute()


    override suspend fun savePointsBalance(pointsBalance: PointsBalance): Boolean =
        savePointsBalanceUseCase.execute(pointsBalance)
}
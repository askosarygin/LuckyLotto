package com.andreykosarygin.game_domain

import com.andreykosarygin.common.PointsBalance
import com.andreykosarygin.common.PointsOperation
import com.andreykosarygin.game_domain.usecases.GetPointsBalanceUseCase
import com.andreykosarygin.game_domain.usecases.SavePointsBalanceUseCase
import com.andreykosarygin.game_domain.usecases.SaveToHistoryOfOperationsUseCase

class InteractorImpl(
    private val getPointsBalanceUseCase: GetPointsBalanceUseCase,
    private val savePointsBalanceUseCase: SavePointsBalanceUseCase,
    private val saveToHistoryOfOperationsUseCase: SaveToHistoryOfOperationsUseCase
) : Interactor {
    override suspend fun getPointsBalance(): PointsBalance = getPointsBalanceUseCase.execute()


    override suspend fun savePointsBalance(pointsBalance: PointsBalance): Boolean =
        savePointsBalanceUseCase.execute(pointsBalance)

    override suspend fun saveToHistoryOfOperations(pointsOperation: PointsOperation): Boolean =
        saveToHistoryOfOperationsUseCase.execute(pointsOperation)
}
package com.andreykosarygin.game_domain

import com.andreykosarygin.common.PointsBalance
import com.andreykosarygin.common.PointsOperation

interface Interactor {
    suspend fun getPointsBalance(): PointsBalance

    suspend fun savePointsBalance(pointsBalance: PointsBalance): Boolean

    suspend fun saveToHistoryOfOperations(pointsOperation: PointsOperation): Boolean
}
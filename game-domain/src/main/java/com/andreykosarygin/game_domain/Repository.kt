package com.andreykosarygin.game_domain

import com.andreykosarygin.common.PointsBalance
import com.andreykosarygin.common.PointsOperation

interface Repository {
    suspend fun getPointsBalanceFromAppData(): PointsBalance

    suspend fun savePointsBalanceToAppData(pointsBalance: PointsBalance): Boolean

    suspend fun saveToHistoryOfOperationsDB(pointsOperation: PointsOperation): Boolean
}
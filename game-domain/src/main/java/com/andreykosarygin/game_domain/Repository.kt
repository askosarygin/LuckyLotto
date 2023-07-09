package com.andreykosarygin.game_domain

import com.andreykosarygin.common.PointsBalance

interface Repository {
    suspend fun getPointsBalanceFromAppData(): PointsBalance

    suspend fun savePointsBalanceToAppData(pointsBalance: PointsBalance): Boolean
}
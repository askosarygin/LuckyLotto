package com.andreykosarygin.game_domain

import com.andreykosarygin.common.PointsBalance

interface Interactor {
    suspend fun getPointsBalance(): PointsBalance

    suspend fun savePointsBalance(pointsBalance: PointsBalance): Boolean
}
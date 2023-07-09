package com.andreykosarygin.balance_domain

import com.andreykosarygin.common.PointsBalance

interface Interactor {
    suspend fun getPointsBalance(): PointsBalance
}
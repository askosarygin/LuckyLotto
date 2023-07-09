package com.andreykosarygin.balance_domain

import com.andreykosarygin.common.PointsBalance

interface Repository {
    suspend fun getPointsBalanceFromAppData(): PointsBalance
}
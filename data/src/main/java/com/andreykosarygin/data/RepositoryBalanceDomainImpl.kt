package com.andreykosarygin.data

import com.andreykosarygin.balance_domain.Repository
import com.andreykosarygin.common.PointsBalance
import com.andreykosarygin.data.appdata.AppData

class RepositoryBalanceDomainImpl(
    private val appData: AppData
):Repository  {
    override suspend fun getPointsBalanceFromAppData(): PointsBalance = appData.getPointsBalance()
}
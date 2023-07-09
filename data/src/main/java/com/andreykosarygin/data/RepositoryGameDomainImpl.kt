package com.andreykosarygin.data

import com.andreykosarygin.common.PointsBalance
import com.andreykosarygin.data.appdata.AppData
import com.andreykosarygin.game_domain.Repository

class RepositoryGameDomainImpl(
    private val appData: AppData
): Repository {
    override suspend fun getPointsBalanceFromAppData(): PointsBalance = appData.getPointsBalance()

    override suspend fun savePointsBalanceToAppData(pointsBalance: PointsBalance): Boolean =
        appData.savePoints(pointsBalance)
}
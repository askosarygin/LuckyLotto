package com.andreykosarygin.data

import com.andreykosarygin.common.PointsBalance
import com.andreykosarygin.common.PointsOperation
import com.andreykosarygin.common.PointsOperationDB
import com.andreykosarygin.data.appdata.AppData
import com.andreykosarygin.data.db.PointsOperationsStorage
import com.andreykosarygin.game_domain.Repository

class RepositoryGameDomainImpl(
    private val appData: AppData,
    private val pointsOperationsStorage: PointsOperationsStorage
): Repository {
    override suspend fun getPointsBalanceFromAppData(): PointsBalance = appData.getPointsBalance()

    override suspend fun savePointsBalanceToAppData(pointsBalance: PointsBalance): Boolean =
        appData.savePoints(pointsBalance)

    override suspend fun saveToHistoryOfOperationsDB(pointsOperation: PointsOperation): Boolean =
        pointsOperationsStorage.save(
            PointsOperationDB(
                pointsOperation.id,
                pointsOperation.date,
                pointsOperation.pointsOperation
            )
        )
}
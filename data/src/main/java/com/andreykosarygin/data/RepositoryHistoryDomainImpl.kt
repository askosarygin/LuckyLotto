package com.andreykosarygin.data

import com.andreykosarygin.common.PointsOperation
import com.andreykosarygin.data.db.PointsOperationsStorage
import com.andreykosarygin.history_domain.Repository

class RepositoryHistoryDomainImpl(
    private val pointsOperationsStorage: PointsOperationsStorage
) : Repository {
    override suspend fun loadHistoryOfPointsOperationsFromDB(): List<PointsOperation> =
        pointsOperationsStorage.getAll().map {
            PointsOperation(
                it.id,
                it.date,
                it.pointsOperation
            )
        }
}
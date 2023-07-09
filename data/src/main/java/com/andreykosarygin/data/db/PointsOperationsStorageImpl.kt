package com.andreykosarygin.data.db

import com.andreykosarygin.common.PointsOperationDB
import javax.inject.Inject

class PointsOperationsStorageImpl @Inject constructor(
    private val database: PointsOperationsDAO
) : PointsOperationsStorage {
    override suspend fun save(pointsOperationDB: PointsOperationDB): Boolean {
        database.add(
            PointsOperationDatabaseClass(
                pointsOperationDB.id,
                pointsOperationDB.date,
                pointsOperationDB.pointsOperation
            )
        )
        return true
    }

    override suspend fun getAll(): List<PointsOperationDB> {
        return database.getAll().map {
            PointsOperationDB(
                it.id,
                it.date,
                it.pointsOperation
            )
        }
    }
}
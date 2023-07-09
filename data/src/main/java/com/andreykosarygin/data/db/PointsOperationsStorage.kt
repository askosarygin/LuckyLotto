package com.andreykosarygin.data.db

import com.andreykosarygin.common.PointsOperationDB

interface PointsOperationsStorage {
    suspend fun save(pointsOperationDB: PointsOperationDB): Boolean

    suspend fun getAll(): List<PointsOperationDB>
}
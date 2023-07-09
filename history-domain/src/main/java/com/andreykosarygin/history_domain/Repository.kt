package com.andreykosarygin.history_domain

import com.andreykosarygin.common.PointsOperation

interface Repository {
    suspend fun loadHistoryOfPointsOperationsFromDB(): List<PointsOperation>
}
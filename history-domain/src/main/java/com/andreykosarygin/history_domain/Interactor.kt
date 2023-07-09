package com.andreykosarygin.history_domain

import com.andreykosarygin.common.PointsOperationInfo

interface Interactor {
    suspend fun loadHistoryOfPointsOperations(): List<PointsOperationInfo>
}
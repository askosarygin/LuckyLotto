package com.andreykosarygin.history_domain

import com.andreykosarygin.common.PointsOperationInfo
import com.andreykosarygin.history_domain.usecases.LoadHistoryOfPointsOperationsUseCase

class InteractorImpl(
    private val loadHistoryOfPointsOperationsUseCase: LoadHistoryOfPointsOperationsUseCase
) : Interactor {
    override suspend fun loadHistoryOfPointsOperations(): List<PointsOperationInfo> =
        loadHistoryOfPointsOperationsUseCase.execute()

}
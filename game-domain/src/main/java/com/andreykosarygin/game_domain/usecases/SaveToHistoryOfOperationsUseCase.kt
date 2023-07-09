package com.andreykosarygin.game_domain.usecases

import com.andreykosarygin.common.PointsOperation
import com.andreykosarygin.game_domain.Repository

class SaveToHistoryOfOperationsUseCase(
    private val repository: Repository
) {
    suspend fun execute(pointsOperation: PointsOperation) =
        repository.saveToHistoryOfOperationsDB(pointsOperation)
}
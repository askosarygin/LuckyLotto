package com.andreykosarygin.history_domain.usecases

import com.andreykosarygin.common.PointsOperationInfo
import com.andreykosarygin.history_domain.Repository
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class LoadHistoryOfPointsOperationsUseCase(
    private val repository: Repository
) {
    suspend fun execute(): List<PointsOperationInfo> {
        val dateFormat = "dd.MM"
        val formatter = SimpleDateFormat(dateFormat, Locale.getDefault())
        val calendar = Calendar.getInstance()

        return repository.loadHistoryOfPointsOperationsFromDB().map {
            calendar.timeInMillis = it.date
            PointsOperationInfo(
                formatter.format(calendar.time),
                getNumberWithPlus(it.pointsOperation)
            )
        }
    }

    private fun getNumberWithPlus(number: Long): String {
        return if (number > 0) {
            buildString {
                append("+")
                append(number.toString())
            }
        } else {
            number.toString()
        }
    }
}
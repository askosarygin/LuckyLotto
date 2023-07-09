package com.andreykosarygin.history_ui.screen_history

import androidx.lifecycle.viewModelScope
import com.andreykosarygin.common.LuckyLottoViewModel
import com.andreykosarygin.common.LuckyLottoViewModelSingleLifeEvent
import com.andreykosarygin.common.PointsOperationInfo
import com.andreykosarygin.history_domain.Interactor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ScreenHistoryViewModel(
    private val interactor: Interactor
) : LuckyLottoViewModel<ScreenHistoryViewModel.Model>(Model()) {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val listOfPointsOperationInfo = interactor.loadHistoryOfPointsOperations()
            updateListOfPointsOperationInfo(listOfPointsOperationInfo)
        }
    }

    fun buttonBackPressed() {
        updateNavigationEvent(
            Model.NavigationSingleLifeEvent(
                Model.NavigationSingleLifeEvent.NavigationDestination.ScreenInfo
            )
        )
    }

    data class Model(
        val listOfPointsOperationInfo: List<PointsOperationInfo> = listOf(),
        val navigationEvent: NavigationSingleLifeEvent? = null
    ) {
        class NavigationSingleLifeEvent(
            navigateTo: NavigationDestination
        ) : LuckyLottoViewModelSingleLifeEvent<NavigationSingleLifeEvent.NavigationDestination>(
            navigateTo
        ) {
            enum class NavigationDestination {
                ScreenInfo
            }
        }
    }

    private fun updateListOfPointsOperationInfo(listOfPointsOperationInfo: List<PointsOperationInfo>) {
        update {
            it.copy(
                listOfPointsOperationInfo = listOfPointsOperationInfo
            )
        }
    }

    private fun updateNavigationEvent(navigationEvent: Model.NavigationSingleLifeEvent) {
        update {
            it.copy(
                navigationEvent = navigationEvent
            )
        }
    }
}
package com.andreykosarygin.balance_ui.screen_balance

import androidx.lifecycle.viewModelScope
import com.andreykosarygin.balance_domain.Interactor
import com.andreykosarygin.common.LuckyLottoViewModel
import com.andreykosarygin.common.LuckyLottoViewModelSingleLifeEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ScreenBalanceViewModel(
    private val interactor: Interactor
) : LuckyLottoViewModel<ScreenBalanceViewModel.Model>(Model()) {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val pointsBalance = interactor.getPointsBalance()
            updatePointsBalance(pointsBalance.balance.toString())
        }
    }

    fun buttonBackPressed() {
        updateNavigationEvent(
            Model.NavigationSingleLifeEvent(
                Model.NavigationSingleLifeEvent.NavigationDestination.ScreenMain
            )
        )
    }

    fun buttonPlayPressed() {
        updateNavigationEvent(
            Model.NavigationSingleLifeEvent(
                Model.NavigationSingleLifeEvent.NavigationDestination.ScreenGame
            )
        )
    }

    data class Model(
        val pointsBalance: String = "0",
        val navigationEvent: NavigationSingleLifeEvent? = null
    ) {
        class NavigationSingleLifeEvent(
            navigateTo: NavigationDestination
        ) : LuckyLottoViewModelSingleLifeEvent<NavigationSingleLifeEvent.NavigationDestination>(
            navigateTo
        ) {
            enum class NavigationDestination {
                ScreenMain,
                ScreenGame,
            }
        }
    }

    private fun updatePointsBalance(pointsBalance: String) {
        update {
            it.copy(
                pointsBalance = pointsBalance
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
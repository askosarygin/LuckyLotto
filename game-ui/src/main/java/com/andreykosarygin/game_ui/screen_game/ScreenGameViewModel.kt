package com.andreykosarygin.game_ui.screen_game

import androidx.lifecycle.viewModelScope
import com.andreykosarygin.common.LuckyLottoViewModel
import com.andreykosarygin.common.LuckyLottoViewModelSingleLifeEvent
import com.andreykosarygin.game_domain.Interactor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ScreenGameViewModel (
    private val interactor: Interactor
) : LuckyLottoViewModel<ScreenGameViewModel.Model>(Model()){

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

    fun buttonInfoPressed() {
        updateNavigationEvent(
            Model.NavigationSingleLifeEvent(
                Model.NavigationSingleLifeEvent.NavigationDestination.ScreenInfo
            )
        )
    }

    fun buttonSpinPressed() {
        viewModelScope.launch(Dispatchers.IO) {

        }
    }

    data class Model(
        val drumIconNeedToShowLeft: Int = 0,
        val drumIconNeedToShowCenter: Int = 0,
        val drumIconNeedToShowRight: Int = 0,
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
                ScreenInfo
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
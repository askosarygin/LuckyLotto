package com.andreykosarygin.main_ui.screen_info

import com.andreykosarygin.common.LuckyLottoViewModel
import com.andreykosarygin.common.LuckyLottoViewModelSingleLifeEvent

class ScreenInfoViewModel (

) : LuckyLottoViewModel<ScreenInfoViewModel.Model>(Model()){

    fun buttonBackPressed(departureArguments: String?) {
        departureArguments?.let {
            val argumentsList = it.split("_")

            if (argumentsList.size > 1) {
                updateDepartureArguments(departureArguments)
                updateNavigationEvent(
                    Model.NavigationSingleLifeEvent(
                        Model.NavigationSingleLifeEvent.NavigationDestination.ScreenGame
                    )
                )
            } else {
                updateNavigationEvent(
                    Model.NavigationSingleLifeEvent(
                        Model.NavigationSingleLifeEvent.NavigationDestination.ScreenMain
                    )
                )
            }
        }

    }

    fun buttonHistoryPressed() {
        updateNavigationEvent(
            Model.NavigationSingleLifeEvent(
                Model.NavigationSingleLifeEvent.NavigationDestination.ScreenHistory
            )
        )
    }

    data class Model(
        val departureArguments: String? = null,
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
                ScreenHistory
            }
        }
    }

    private fun updateDepartureArguments(departureArguments: String) {
        update {
            it.copy(
                departureArguments = departureArguments
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
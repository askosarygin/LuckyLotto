package com.andreykosarygin.game_ui.screen_game

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.andreykosarygin.common.LuckyLottoViewModel
import com.andreykosarygin.common.LuckyLottoViewModelSingleLifeEvent
import javax.inject.Inject

class ScreenGameViewModel @Inject constructor(

) : LuckyLottoViewModel<ScreenGameViewModel.Model>(Model()){

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

    data class Model(
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

    private fun updateNavigationEvent(navigationEvent: Model.NavigationSingleLifeEvent) {
        update {
            it.copy(
                navigationEvent = navigationEvent
            )
        }
    }

    class Factory @Inject constructor(

    ) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            require(modelClass == ScreenGameViewModel::class.java)
            return ScreenGameViewModel(

            ) as T
        }
    }
}
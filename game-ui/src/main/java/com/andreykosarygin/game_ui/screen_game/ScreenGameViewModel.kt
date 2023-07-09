package com.andreykosarygin.game_ui.screen_game

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.andreykosarygin.common.LuckyLottoViewModel
import com.andreykosarygin.common.LuckyLottoViewModelSingleLifeEvent
import com.andreykosarygin.common.PointsBalance
import com.andreykosarygin.game_domain.Interactor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ScreenGameViewModel(
    private val interactor: Interactor
) : LuckyLottoViewModel<ScreenGameViewModel.Model>(Model()) {

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

    fun buttonSpinPressed(howMuchIconsInDrum: Int) {
        val drumIconNeedToShowLeft = (0 until howMuchIconsInDrum).random()
        val drumIconNeedToShowCenter = (0 until howMuchIconsInDrum).random()
        val drumIconNeedToShowRight = (0 until howMuchIconsInDrum).random()

        Log.i(
            "MY_TAG", "drumIconNeedToShowLeft=$drumIconNeedToShowLeft\n" +
                    "drumIconNeedToShowCenter=$drumIconNeedToShowCenter\n" +
                    "drumIconNeedToShowRight=$drumIconNeedToShowRight"
        )

        updateDrumIconNeedToShowLeft(drumIconNeedToShowLeft)
        updateDrumIconNeedToShowCenter(drumIconNeedToShowCenter)
        updateDrumIconNeedToShowRight(drumIconNeedToShowRight)

        updatePlayAnimation(true)
    }

    fun buttonRespinPressed() {
        updateShowPopupWindow(false)
    }

    fun animationFinished() {
        updatePlayAnimation(false)

        model.value.apply {
            when {
                (drumIconNeedToShowLeft == drumIconNeedToShowCenter) && (drumIconNeedToShowCenter == drumIconNeedToShowRight) ->
                    showPopupAndUpdatePoints(1000L)

                (drumIconNeedToShowLeft == drumIconNeedToShowCenter) || (drumIconNeedToShowCenter == drumIconNeedToShowRight) || (drumIconNeedToShowLeft == drumIconNeedToShowRight) ->
                    showPopupAndUpdatePoints(100L)

                else -> showPopupAndUpdatePoints(-5L)
            }
        }
    }

    private fun showPopupAndUpdatePoints(earnPoints: Long) {
        updateEarnPoints(earnPoints.toString())
        updateShowPopupWindow(true)
        viewModelScope.launch(Dispatchers.IO) {
            interactor.savePointsBalance(
                PointsBalance(
                    earnPoints
                )
            )
            val pointsBalance = interactor.getPointsBalance()
            updatePointsBalance(pointsBalance.balance.toString())
        }
    }

    data class Model(
        val playAnimation: Boolean = false,
        val drumIconNeedToShowLeft: Int = 5,
        val drumIconNeedToShowCenter: Int = 5,
        val drumIconNeedToShowRight: Int = 5,
        val earnPoints: String = "0",
        val showPopupWindow: Boolean = false,
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

    private fun updateShowPopupWindow(showPopupWindow: Boolean) {
        update {
            it.copy(
                showPopupWindow = showPopupWindow
            )
        }
    }

    private fun updateEarnPoints(earnPoints: String) {
        update {
            it.copy(
                earnPoints = earnPoints
            )
        }
    }

    private fun updatePlayAnimation(playAnimation: Boolean) {
        update {
            it.copy(
                playAnimation = playAnimation
            )
        }
    }

    private fun updateDrumIconNeedToShowLeft(drumIconNeedToShowLeft: Int) {
        update {
            it.copy(
                drumIconNeedToShowLeft = drumIconNeedToShowLeft
            )
        }
    }

    private fun updateDrumIconNeedToShowCenter(drumIconNeedToShowCenter: Int) {
        update {
            it.copy(
                drumIconNeedToShowCenter = drumIconNeedToShowCenter
            )
        }
    }

    private fun updateDrumIconNeedToShowRight(drumIconNeedToShowRight: Int) {
        update {
            it.copy(
                drumIconNeedToShowRight = drumIconNeedToShowRight
            )
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
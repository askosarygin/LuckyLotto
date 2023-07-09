package com.andreykosarygin.luckylotto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.andreykosarygin.balance_ui.screen_balance.ScreenBalance
import com.andreykosarygin.common.NavigationRoutes.SCREEN_BALANCE
import com.andreykosarygin.common.NavigationRoutes.SCREEN_GAME
import com.andreykosarygin.common.NavigationRoutes.SCREEN_HISTORY
import com.andreykosarygin.common.NavigationRoutes.SCREEN_INFO
import com.andreykosarygin.common.NavigationRoutes.SCREEN_MAIN
import com.andreykosarygin.game_ui.screen_game.ScreenGame
import com.andreykosarygin.history_ui.screen_history.ScreenHistory
import com.andreykosarygin.main_ui.screen_info.ScreenInfo
import com.andreykosarygin.main_ui.screen_main.ScreenMain

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            NavHost(navController = navController, startDestination = SCREEN_MAIN) {
                composable(route = SCREEN_MAIN) {
                    ScreenMain(navController = navController)
                }
                composable(route = SCREEN_GAME) {
                    ScreenGame(navController = navController)
                }
                composable(route = SCREEN_INFO) {
                    ScreenInfo(navController = navController)
                }
                composable(route = SCREEN_BALANCE) {
                    ScreenBalance(navController = navController)
                }
                composable(route = SCREEN_HISTORY) {
                    ScreenHistory(navController = navController)
                }
            }
        }
    }
}
package com.andreykosarygin.luckylotto

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.andreykosarygin.balance_ui.screen_balance.ScreenBalance
import com.andreykosarygin.balance_ui.screen_balance.ScreenBalanceViewModel
import com.andreykosarygin.common.NavigationRoutes.SCREEN_BALANCE
import com.andreykosarygin.common.NavigationRoutes.SCREEN_GAME
import com.andreykosarygin.common.NavigationRoutes.SCREEN_HISTORY
import com.andreykosarygin.common.NavigationRoutes.SCREEN_INFO
import com.andreykosarygin.common.NavigationRoutes.SCREEN_MAIN
import com.andreykosarygin.data.RepositoryBalanceDomainImpl
import com.andreykosarygin.data.RepositoryGameDomainImpl
import com.andreykosarygin.data.RepositoryHistoryDomainImpl
import com.andreykosarygin.data.appdata.AppDataImpl
import com.andreykosarygin.data.db.PointsOperationsDatabase
import com.andreykosarygin.data.db.PointsOperationsStorage
import com.andreykosarygin.data.db.PointsOperationsStorageImpl
import com.andreykosarygin.game_domain.InteractorImpl
import com.andreykosarygin.game_domain.usecases.GetPointsBalanceUseCase
import com.andreykosarygin.game_domain.usecases.SavePointsBalanceUseCase
import com.andreykosarygin.game_domain.usecases.SaveToHistoryOfOperationsUseCase
import com.andreykosarygin.game_ui.screen_game.ScreenGame
import com.andreykosarygin.game_ui.screen_game.ScreenGameViewModel
import com.andreykosarygin.history_domain.usecases.LoadHistoryOfPointsOperationsUseCase
import com.andreykosarygin.history_ui.screen_history.ScreenHistory
import com.andreykosarygin.history_ui.screen_history.ScreenHistoryViewModel
import com.andreykosarygin.main_ui.screen_info.ScreenInfo
import com.andreykosarygin.main_ui.screen_info.ScreenInfoViewModel
import com.andreykosarygin.main_ui.screen_main.ScreenMain
import com.andreykosarygin.main_ui.screen_main.ScreenMainViewModel

class MainApp : Application() {
    private val sharedPreferencesName = "lucky_lotto_shared_preferences"
    private val dbName = "lucky_lotto_db"

    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var appDataImpl: AppDataImpl
    private lateinit var pointsOperationsStorage: PointsOperationsStorage
    private lateinit var repositoryGameDomainImpl: RepositoryGameDomainImpl
    lateinit var interactorImplGameDomain: InteractorImpl

    private lateinit var repositoryHistoryDomainImpl: RepositoryHistoryDomainImpl
    lateinit var interactorImplHistoryDomain: com.andreykosarygin.history_domain.InteractorImpl

    private lateinit var repositoryBalanceDomainImpl: RepositoryBalanceDomainImpl
    lateinit var interactorImplBalanceDomain: com.andreykosarygin.balance_domain.InteractorImpl

    override fun onCreate() {
        super.onCreate()

        sharedPreferences = this.getSharedPreferences(sharedPreferencesName, Context.MODE_PRIVATE)
        appDataImpl = AppDataImpl(sharedPreferences)
        pointsOperationsStorage = PointsOperationsStorageImpl(
            Room.databaseBuilder(this, PointsOperationsDatabase::class.java, dbName)
                .build()
                .pointsOperationsDAO()
        )
        repositoryGameDomainImpl = RepositoryGameDomainImpl(appDataImpl, pointsOperationsStorage)
        interactorImplGameDomain = InteractorImpl(
            GetPointsBalanceUseCase(repositoryGameDomainImpl),
            SavePointsBalanceUseCase(repositoryGameDomainImpl),
            SaveToHistoryOfOperationsUseCase(repositoryGameDomainImpl)
        )


        repositoryHistoryDomainImpl = RepositoryHistoryDomainImpl(pointsOperationsStorage)
        interactorImplHistoryDomain = com.andreykosarygin.history_domain.InteractorImpl(
            LoadHistoryOfPointsOperationsUseCase(
                repositoryHistoryDomainImpl
            )
        )

        repositoryBalanceDomainImpl = RepositoryBalanceDomainImpl(appDataImpl)
        interactorImplBalanceDomain = com.andreykosarygin.balance_domain.InteractorImpl(
            com.andreykosarygin.balance_domain.usecases.GetPointsBalanceUseCase(
                repositoryBalanceDomainImpl
            )
        )
    }
}

class MainActivity : ComponentActivity() {
    private fun getApplicationInstance() = application as MainApp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()

            NavHost(navController = navController, startDestination = SCREEN_MAIN) {
                composable(route = SCREEN_MAIN) {
                    ScreenMain(navController = navController, viewModel = ScreenMainViewModel())
                }
                composable(route = SCREEN_GAME) {
                    ScreenGame(
                        navController = navController, viewModel = ScreenGameViewModel(
                            getApplicationInstance().interactorImplGameDomain
                        )
                    )
                }
                composable(route = SCREEN_INFO) {
                    ScreenInfo(navController = navController, viewModel = ScreenInfoViewModel())
                }
                composable(route = SCREEN_BALANCE) {
                    ScreenBalance(
                        navController = navController,
                        viewModel = ScreenBalanceViewModel(
                            getApplicationInstance().interactorImplBalanceDomain
                        )
                    )
                }
                composable(route = SCREEN_HISTORY) {
                    ScreenHistory(
                        navController = navController,
                        viewModel = ScreenHistoryViewModel(
                            getApplicationInstance().interactorImplHistoryDomain
                        )
                    )
                }
            }
        }
    }
}
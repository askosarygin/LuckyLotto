package com.andreykosarygin.luckylotto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.andreykosarygin.game_ui.screen_game.ScreenGame

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var playDrumAnimation by remember { mutableStateOf(false) }
            
            ScreenGame(
                onClickBack = { /*TODO*/ },
                onClickInfo = { /*TODO*/ },
                onClickSpin = {
                    playDrumAnimation = true
                },
                balance = "25",
                playAnimation = playDrumAnimation,
                drumIconShowLeft = 4,
                drumIconShowCenter = 3,
                drumIconShowRight = 0,
                drumAnimationFinished = {
                    playDrumAnimation = false
                }
            )
        }
    }
}
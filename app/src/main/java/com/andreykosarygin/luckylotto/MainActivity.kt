package com.andreykosarygin.luckylotto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.andreykosarygin.main_ui.screen_main.ScreenMain

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScreenMain(onClickStart = { /*TODO*/ }, onClickBalance = { /*TODO*/ }) {

            }
        }
    }
}
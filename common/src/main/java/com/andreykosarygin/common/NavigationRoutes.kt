package com.andreykosarygin.common

object NavigationRoutes {
    const val DEPARTURE_KEY = "departure_key"

    const val SCREEN_MAIN = "ScreenMain"
    const val SCREEN_GAME = "ScreenGame/{$DEPARTURE_KEY}"
    const val SCREEN_INFO = "ScreenInfo/{$DEPARTURE_KEY}"
    const val SCREEN_BALANCE = "ScreenBalance"
    const val SCREEN_HISTORY = "ScreenHistory/{$DEPARTURE_KEY}"
}
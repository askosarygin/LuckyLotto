package com.andreykosarygin.data.appdata

import android.content.SharedPreferences
import com.andreykosarygin.common.PointsBalance

class AppDataImpl (
    private val sharedPreferences: SharedPreferences
) : AppData {
    private val keyPointsBalance = "key_points_balance"

    override fun savePoints(pointsBalance: PointsBalance): Boolean {
        sharedPreferences.edit().putLong(keyPointsBalance, pointsBalance.balance).apply()
        return true
    }

    override fun getPointsBalance(): PointsBalance {
        val balance = sharedPreferences.getLong(keyPointsBalance, 0L)
        return PointsBalance(balance)
    }
}
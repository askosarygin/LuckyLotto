package com.andreykosarygin.data.appdata

import com.andreykosarygin.common.PointsBalance

interface AppData {
    fun savePoints(pointsBalance: PointsBalance): Boolean

    fun getPointsBalance(): PointsBalance
}
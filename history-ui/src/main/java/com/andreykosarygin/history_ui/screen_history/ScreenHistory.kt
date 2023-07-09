package com.andreykosarygin.history_ui.screen_history

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.andreykosarygin.common.LuckyLottoButton
import com.andreykosarygin.common.LuckyLottoCommonBackground
import com.andreykosarygin.common.LuckyLottoWhiteText
import com.andreykosarygin.common.NavigationRoutes.SCREEN_INFO
import com.andreykosarygin.common.PointsInfo
import com.andreykosarygin.common.R

@SuppressLint("UnrememberedMutableState")
@Preview(showBackground = true)
@Composable
private fun Preview() {
//    ScreenHistory()
}

@Composable
fun ScreenHistory(
    navController: NavController
) {
    val listPointsInfo = remember {
        mutableStateListOf(
            PointsInfo(
                "21.08",
                "+15"
            ),
            PointsInfo(
                "22.08",
                "+10"
            ),
            PointsInfo(
                "23.08",
                "-20"
            ),
        )
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        LuckyLottoCommonBackground(onClickBackArrow = {
            navController.navigate(SCREEN_INFO)
        })

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 86.dp),
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.size(width = 351.dp, height = 567.dp)
            ) {
                Image(
                    modifier = Modifier.size(width = 351.dp, height = 567.dp),
                    painter = painterResource(id = R.drawable.background_info),
                    contentDescription = stringResource(
                        id = R.string.content_description_background_info
                    ),
                    contentScale = ContentScale.FillBounds
                )
                Box(
                    contentAlignment = Alignment.TopCenter,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(vertical = 35.dp)
                ) {
                    LazyColumn {
                        items(items = listPointsInfo) { pointsInfo ->
                            LuckyLottoWhiteText(
                                text = "${pointsInfo.date}                      ${pointsInfo.operationValue}",
                                fontSize = 32.sp,
                                font = Font(resId = R.font.bitter_700)
                            )
                        }
                    }
                }
            }

            LuckyLottoButton(
                paddingValues = PaddingValues(top = 6.dp),
                text = stringResource(id = R.string.history),
                onClick = {}
            )
        }
    }
}
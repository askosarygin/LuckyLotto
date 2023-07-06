package com.andreykosarygin.game_ui.screen_game

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.andreykosarygin.common.LuckyLottoButton
import com.andreykosarygin.common.LuckyLottoCommonBackground
import com.andreykosarygin.common.LuckyLottoGradientText
import com.andreykosarygin.common.LuckyLottoWhiteText
import com.andreykosarygin.common.R

@SuppressLint("UnrememberedMutableState")
@Preview(showBackground = true)
@Composable
private fun Preview() {
    ScreenGame({}, {}, {}, "25")
}

@Composable
fun ScreenGame(
    onClickBack: () -> Unit,
    onClickInfo: () -> Unit,
    onClickSpin: () -> Unit,
    balance: String
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        LuckyLottoCommonBackground(onClickBackArrow = onClickBack)

        ButtonInfo(onClickInfo = onClickInfo)

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.TopCenter
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                PointsValue(balance = balance)

                Header(
                    modifier = Modifier.padding(top = 14.dp, bottom = 33.dp)
                )

                SlotMachine()

                LuckyLottoButton(
                    text = stringResource(id = R.string.spin),
                    onClick = onClickSpin,
                    paddingValues = PaddingValues(top = 93.dp)
                )
            }
        }
    }
}

@Composable
fun SlotMachine() {
    Box(
        modifier = Modifier.offset(x = 14.dp),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier.size(width = 373.dp, height = 244.dp),
            painter = painterResource(
                id = com.andreykosarygin.game_ui.R.drawable.slot_machine_empty
            ),
            contentDescription = stringResource(id = R.string.content_description_slot_machine)
        )
    }
}

@Composable
private fun ButtonInfo(
    onClickInfo: () -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopEnd
    ) {
        IconButton(
            onClick = onClickInfo,
            modifier = Modifier
                .padding(end = 19.dp, top = 20.dp)
                .size(width = 53.dp, height = 47.dp)
        ) {
            Image(
                modifier = Modifier.size(width = 47.dp, height = 46.dp),
                painter = painterResource(id = com.andreykosarygin.game_ui.R.drawable.icon_info),
                contentDescription = stringResource(id = R.string.content_description_back_arrow)
            )
        }
    }
}

@Composable
private fun Header(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.TopCenter
    ) {
        Image(
            modifier = Modifier.size(width = 235.dp, height = 116.dp),
            painter = painterResource(id = com.andreykosarygin.game_ui.R.drawable.background_header),
            contentDescription = stringResource(id = R.string.content_description_background)
        )
        LuckyLottoGradientText(
            modifier = Modifier.offset(y = (-1).dp, x = (-3).dp),
            text = stringResource(id = R.string.header_app_name_1),
            fontSize = 27.36.sp,
            font = Font(resId = R.font.bitter_600)
        )
        LuckyLottoGradientText(
            modifier = Modifier
                .padding(top = 26.dp)
                .offset(x = (-4).dp),
            text = stringResource(id = R.string.header_app_name_2),
            fontSize = 47.6.sp,
            font = Font(resId = R.font.bitter_900)
        )
    }
}

@Composable
fun PointsValue(
    balance: String
) {
    Box(contentAlignment = Alignment.Center) {
        Image(
            modifier = Modifier.size(width = 89.dp, height = 89.dp),
            painter = painterResource(
                id = com.andreykosarygin.game_ui.R.drawable.background_points
            ),
            contentDescription = stringResource(id = R.string.content_description_background_points)
        )

        LuckyLottoWhiteText(
            text = balance,
            fontSize = 27.16.sp,
            font = Font(resId = R.font.bitter_900)
        )
    }
}
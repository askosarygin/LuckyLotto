package com.andreykosarygin.balance_ui.screen_balance

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.andreykosarygin.balance_ui.R
import com.andreykosarygin.common.LuckyLottoButton
import com.andreykosarygin.common.LuckyLottoCommonBackground
import com.andreykosarygin.common.LuckyLottoGradientText
import com.andreykosarygin.common.LuckyLottoWhiteText

@Preview(showBackground = true)
@Composable
private fun Preview() {
    ScreenBalance({},{}, "25")
}

@Composable
fun ScreenBalance(
    onClickBack: () -> Unit,
    onClickPlay: () -> Unit,
    balance: String
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        LuckyLottoCommonBackground(onClickBackArrow = onClickBack)

        Column(
            modifier = Modifier.padding(top = 180.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Balance(
                modifier = Modifier.offset(x = 12.dp),
                balance = balance
            )

            LuckyLottoButton(
                paddingValues = PaddingValues(top = 138.dp),
                text = stringResource(
                    id = com.andreykosarygin.common.R.string.button_play
                ),
                onClick = onClickPlay
            )
        }
    }
}

@Composable
fun Balance(
    modifier: Modifier = Modifier,
    balance: String
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.TopCenter
    ) {
        Image(
            modifier = Modifier.size(width = 358.dp, height = 236.dp),
            painter = painterResource(
                id = R.drawable.background_slot_machine_balance
            ),
            contentDescription = stringResource(
                id = com.andreykosarygin.common.R.string.content_description_balance_info_background
            )
        )

        LuckyLottoGradientText(
            modifier = Modifier
                .padding(top = 15.dp)
                .offset(x = (-12).dp),
            text = stringResource(
                id = com.andreykosarygin.common.R.string.balance
            ),
            fontSize = 49.76.sp,
            font = Font(resId = com.andreykosarygin.common.R.font.bitter_900)
        )

        LuckyLottoWhiteText(
            modifier = Modifier
                .padding(top = 135.dp)
                .offset(x = (-12).dp),
            text = balance,
            fontSize = 44.76.sp,
            font = Font(resId = com.andreykosarygin.common.R.font.bitter_900)
        )
    }
}
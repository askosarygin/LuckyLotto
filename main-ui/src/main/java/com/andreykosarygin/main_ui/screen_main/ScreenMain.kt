package com.andreykosarygin.main_ui.screen_main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.andreykosarygin.common.LuckyLottoButton
import com.andreykosarygin.common.LuckyLottoGradientText
import com.andreykosarygin.common.LuckyLottoWhiteText
import com.andreykosarygin.common.NavigationRoutes.SCREEN_BALANCE
import com.andreykosarygin.main_ui.R

//@Preview(showBackground = true)
//@Composable
//private fun Preview() {
//    ScreenMain()
//}

@Composable
fun ScreenMain(
    navController: NavController,
    viewModel: ScreenMainViewModel
) {
    val model by viewModel.model.collectAsState()

    model.navigationEvent?.use { route ->
        when (route) {
            ScreenMainViewModel.Model.NavigationSingleLifeEvent.NavigationDestination.ScreenGame ->
                navController.navigate(
                    buildString {
                        append("ScreenGame/")
                        append("emptyArgument")
                    }
                )
            ScreenMainViewModel.Model.NavigationSingleLifeEvent.NavigationDestination.ScreenBalance ->
                navController.navigate(SCREEN_BALANCE)
            ScreenMainViewModel.Model.NavigationSingleLifeEvent.NavigationDestination.ScreenInfo ->
                navController.navigate("ScreenInfo/screenmain")
        }
    }

    Box {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(
                id = R.drawable.background_main_screen
            ),
            contentDescription = stringResource(id = com.andreykosarygin.common.R.string.content_description_background),
            alignment = Alignment.TopCenter,
            contentScale = ContentScale.Crop
        )

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Header(modifier = Modifier.offset(x = 5.dp))

                SlotMachine(
                    modifier = Modifier
                        .offset(x = 12.dp)
                        .padding(bottom = 22.dp)
                )

                LuckyLottoButton(
                    paddingValues = PaddingValues(bottom = 19.dp),
                    text = stringResource(id = com.andreykosarygin.common.R.string.button_start),
                    onClick = {
                        viewModel.buttonStartPressed()
                    }
                )

                LuckyLottoButton(
                    paddingValues = PaddingValues(bottom = 19.dp),
                    text = stringResource(id = com.andreykosarygin.common.R.string.button_balance),
                    onClick = {
                        viewModel.buttonBalancePressed()
                    }
                )

                LuckyLottoButton(
                    paddingValues = PaddingValues(bottom = 19.dp),
                    text = stringResource(id = com.andreykosarygin.common.R.string.button_info),
                    onClick = {
                        viewModel.buttonInfoPressed()
                    }
                )
            }
        }

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.CenterStart
        ) {
            Image(
                modifier = Modifier
                    .size(width = 124.dp, height = 566.dp)
                    .offset(x = (-37).dp, y = (-94).dp)
                ,
                painter = painterResource(
                    id = R.drawable.background_chips_left
                ),
                contentDescription = stringResource(id = com.andreykosarygin.common.R.string.content_description_background)
            )
        }
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.CenterEnd
        ) {
            Image(
                modifier = Modifier
                    .size(width = 93.dp, height = 457.dp)
                    .offset(x = 38.dp, y = (-8).dp)
                ,
                painter = painterResource(
                    id = R.drawable.background_chips_right
                ),
                contentDescription = stringResource(id = com.andreykosarygin.common.R.string.content_description_background)
            )
        }
    }
}

@Composable
private fun SlotMachine(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.TopCenter
    ) {
        Image(
            modifier = Modifier.size(width = 332.dp, height = 218.dp),
            painter = painterResource(id = R.drawable.background_slot_machine),
            contentDescription = stringResource(id = com.andreykosarygin.common.R.string.content_description_background)
        )
        LuckyLottoGradientText(
            modifier = Modifier
                .padding(top = 14.dp)
                .offset(x = (-12).dp),
            text = stringResource(id = com.andreykosarygin.common.R.string.slot_machine_jackpot),
            fontSize = 44.2.sp,
            font = Font(resId = com.andreykosarygin.common.R.font.bitter_900)
        )
        LuckyLottoWhiteText(
            modifier = Modifier
                .padding(top = 182.dp)
                .offset(x = (-12).dp),
            text = stringResource(id = com.andreykosarygin.common.R.string.slot_machine_scratch_to_win),
            fontSize = 14.3.sp,
            font = Font(resId = com.andreykosarygin.common.R.font.bitter_700)
        )
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
            modifier = Modifier.size(width = 337.dp, height = 165.dp),
            painter = painterResource(id = R.drawable.background_header),
            contentDescription = stringResource(id = com.andreykosarygin.common.R.string.content_description_background)
        )
        LuckyLottoGradientText(
            modifier = Modifier.offset(y = (-4).dp, x = (-3).dp),
            text = stringResource(id = com.andreykosarygin.common.R.string.header_app_name_1),
            fontSize = 39.31.sp,
            font = Font(resId = com.andreykosarygin.common.R.font.bitter_600)
        )
        LuckyLottoGradientText(
            modifier = Modifier
                .padding(top = 27.dp)
                .offset(x = (-7).dp),
            text = stringResource(id = com.andreykosarygin.common.R.string.header_app_name_2),
            fontSize = 68.4.sp,
            font = Font(resId = com.andreykosarygin.common.R.font.bitter_900)
        )
        Row(
            modifier = Modifier
                .padding(top = 116.dp)
                .offset(x = (-10).dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            LuckyLottoGradientText(
                text = stringResource(id = com.andreykosarygin.common.R.string.header_top_prize_text),
                fontSize = 15.02.sp,
                font = Font(resId = com.andreykosarygin.common.R.font.bitter_600)
            )
            LuckyLottoGradientText(
                text = stringResource(id = com.andreykosarygin.common.R.string.header_top_prize_count),
                fontSize = 19.76.sp,
                font = Font(resId = com.andreykosarygin.common.R.font.bitter_600)
            )
        }
    }
}


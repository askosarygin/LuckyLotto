package com.andreykosarygin.main_ui.screen_info

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
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
import com.andreykosarygin.common.LuckyLottoCommonBackground
import com.andreykosarygin.common.LuckyLottoWhiteText
import com.andreykosarygin.common.NavigationRoutes.SCREEN_MAIN

//@Preview(showBackground = true)
//@Composable
//private fun Preview() {
//    ScreenInfo(
//        "",
//        _,
//        ScreenInfoViewModel()
//    )
//}

@Composable
fun ScreenInfo(
    departureArguments: String?,
    navController: NavController,
    viewModel: ScreenInfoViewModel
) {
    val model by viewModel.model.collectAsState()

    model.navigationEvent?.use { route ->
        when (route) {
            ScreenInfoViewModel.Model.NavigationSingleLifeEvent.NavigationDestination.ScreenMain ->
                navController.navigate(SCREEN_MAIN)
            ScreenInfoViewModel.Model.NavigationSingleLifeEvent.NavigationDestination.ScreenGame ->
                navController.navigate(
                    buildString {
                        append("ScreenGame/")
                        append(model.departureArguments)
                    }
                )
            ScreenInfoViewModel.Model.NavigationSingleLifeEvent.NavigationDestination.ScreenHistory ->
                navController.navigate(
                    buildString {
                        append("ScreenHistory/")
                        append(departureArguments)
                    }
                )
        }
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        LuckyLottoCommonBackground(onClickBackArrow = {
            viewModel.buttonBackPressed(departureArguments)
        })

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize(),
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.padding(top = 86.dp)
            ) {
                Image(
                    modifier = Modifier.size(width = 351.dp, height = 567.dp),
                    painter = painterResource(id = com.andreykosarygin.common.R.drawable.background_info),
                    contentDescription = stringResource(
                        id = com.andreykosarygin.common.R.string.content_description_background_info
                    ),
                    contentScale = ContentScale.FillBounds
                )
                LuckyLottoWhiteText(
                    text = stringResource(
                        id = com.andreykosarygin.common.R.string.info_description
                    ),
                    fontSize = 28.sp,
                    font = Font(resId = com.andreykosarygin.common.R.font.bitter_700),
                    modifier = Modifier.padding(horizontal = 60.dp)
                )
            }

            LuckyLottoButton(
                paddingValues = PaddingValues(top = 6.dp),
                text = stringResource(id = com.andreykosarygin.common.R.string.history),
                onClick = {
                    viewModel.buttonHistoryPressed()
                }
            )
        }
    }
}
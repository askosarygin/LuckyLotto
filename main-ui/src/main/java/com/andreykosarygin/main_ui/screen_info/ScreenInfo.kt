package com.andreykosarygin.main_ui.screen_info

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.andreykosarygin.common.LuckyLottoButton
import com.andreykosarygin.common.LuckyLottoCommonBackground
import com.andreykosarygin.common.LuckyLottoWhiteText
import com.andreykosarygin.main_ui.R

@Preview(showBackground = true)
@Composable
private fun Preview() {
    ScreenInfo({},{})
}

@Composable
fun ScreenInfo(
    onClickBack: () -> Unit,
    onClickHistory: () -> Unit,
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        LuckyLottoCommonBackground(onClickBackArrow = onClickBack)

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
                    painter = painterResource(id = R.drawable.background_info),
                    contentDescription = stringResource(
                        id = com.andreykosarygin.common.R.string.content_description_background_info
                    ),
                    contentScale = ContentScale.FillBounds
                )
                LuckyLottoWhiteText(
                    text = stringResource(
                        id = com.andreykosarygin.common.R.string.info_description
                    ),
                    fontSize = 32.sp,
                    font = Font(resId = com.andreykosarygin.common.R.font.bitter_700),
                    modifier = Modifier.padding(horizontal = 60.dp)
                )
            }

            LuckyLottoButton(
                paddingValues = PaddingValues(top = 6.dp),
                text = stringResource(id = com.andreykosarygin.common.R.string.history),
                onClick = onClickHistory
            )
        }
    }
}
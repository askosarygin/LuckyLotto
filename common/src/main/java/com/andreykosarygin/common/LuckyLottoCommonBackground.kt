package com.andreykosarygin.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
private fun Preview() {
    LuckyLottoCommonBackground {}
}

@Composable
fun LuckyLottoCommonBackground(
    onClickBackArrow: () -> Unit
) {
    Box {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(
                id = R.drawable.background_main_screen
            ),
            contentDescription = stringResource(id = R.string.content_description_background),
            alignment = Alignment.TopCenter,
            contentScale = ContentScale.Crop
        )

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.TopStart
        ) {
            IconButton(
                onClick = onClickBackArrow,
                modifier = Modifier
                    .padding(start = 19.dp, top = 20.dp)
                    .size(width = 53.dp, height = 47.dp)
            ) {
                Image(
                    modifier = Modifier.size(width = 53.dp, height = 47.dp),
                    painter = painterResource(id = R.drawable.icon_arrow_back),
                    contentDescription = stringResource(id = R.string.content_description_back_arrow)
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
                    .offset(x = (-53).dp, y = (-25).dp),
                painter = painterResource(
                    id = R.drawable.background_chips_left
                ),
                contentDescription = stringResource(id = R.string.content_description_background)
            )
        }
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.CenterEnd
        ) {
            Image(
                modifier = Modifier
                    .size(width = 93.dp, height = 457.dp)
                    .offset(x = 54.dp, y = (71).dp),
                painter = painterResource(
                    id = R.drawable.background_chips_right
                ),
                contentDescription = stringResource(id = R.string.content_description_background)
            )
        }
    }
}
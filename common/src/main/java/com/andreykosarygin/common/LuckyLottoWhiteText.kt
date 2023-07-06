package com.andreykosarygin.common

import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit

@Composable
fun LuckyLottoWhiteText(
    modifier: Modifier = Modifier,
    text: String,
    fontSize: TextUnit,
    font: Font
) {
    BasicText(
        modifier = modifier,
        text = text,
        style = TextStyle(
            color = colorResource(id = R.color.lucky_lotto_white),
            fontFamily = FontFamily(
                font
            ),
            platformStyle = PlatformTextStyle(
                includeFontPadding = false
            ),
            fontSize = fontSize,
            textAlign = TextAlign.Center
        )
    )
}
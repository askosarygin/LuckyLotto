package com.andreykosarygin.common

import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.TextUnit

@OptIn(ExperimentalTextApi::class)
@Composable
fun LuckyLottoGradientText(
    modifier: Modifier = Modifier,
    text: String,
    fontSize: TextUnit,
    font: Font
) {
    BasicText(
        modifier = modifier,
        text = text,
        style = TextStyle(
            brush = Brush.verticalGradient(
                colors = listOf(
                    colorResource(id = R.color.lucky_lotto_font_gradient_1),
                    colorResource(id = R.color.lucky_lotto_font_gradient_2),
                    colorResource(id = R.color.lucky_lotto_font_gradient_3),
                    colorResource(id = R.color.lucky_lotto_font_gradient_4),
                    colorResource(id = R.color.lucky_lotto_font_gradient_5),
                )
            ),
            fontFamily = FontFamily(
                font
            ),
            platformStyle = PlatformTextStyle(
                includeFontPadding = false
            ),
            fontSize = fontSize
        )
    )
}
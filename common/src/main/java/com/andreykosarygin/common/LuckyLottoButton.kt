package com.andreykosarygin.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun Preview() {
    LuckyLottoButton("BALANCE") {

    }
}

@Composable
fun LuckyLottoButton(
    text: String,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        colorResource(id = R.color.lucky_lotto_button_gradient_1),
                        colorResource(id = R.color.lucky_lotto_button_gradient_2),
                        colorResource(id = R.color.lucky_lotto_button_gradient_3),
                        colorResource(id = R.color.lucky_lotto_button_gradient_4),
                        colorResource(id = R.color.lucky_lotto_button_gradient_5),
                        colorResource(id = R.color.lucky_lotto_button_gradient_6),
                        colorResource(id = R.color.lucky_lotto_button_gradient_7),
                        colorResource(id = R.color.lucky_lotto_button_gradient_8),
                        colorResource(id = R.color.lucky_lotto_button_gradient_9),
                        colorResource(id = R.color.lucky_lotto_button_gradient_10),
                        colorResource(id = R.color.lucky_lotto_button_gradient_11),
                        colorResource(id = R.color.lucky_lotto_button_gradient_12)
                    )
                ),
                shape = RoundedCornerShape(size = 16.dp),
            )
            .size(
                width = 274.dp,
                height = 71.dp
            ),
        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
    ) {
        BasicText(
            text = text,
            style = TextStyle(
                fontSize = 48.sp,
                fontFamily = FontFamily(
                    Font(
                        resId = R.font.bitter_bold
                    )
                ),
                color = colorResource(id = R.color.lucky_lotto_red),
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false
                )
            )
        )
    }
}
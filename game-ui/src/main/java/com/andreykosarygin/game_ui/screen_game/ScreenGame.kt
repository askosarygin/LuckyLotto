package com.andreykosarygin.game_ui.screen_game

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.andreykosarygin.common.LuckyLottoButton
import com.andreykosarygin.common.LuckyLottoCommonBackground
import com.andreykosarygin.common.LuckyLottoGradientText
import com.andreykosarygin.common.LuckyLottoWhiteText
import com.andreykosarygin.common.NavigationRoutes.SCREEN_MAIN
import com.andreykosarygin.common.R

//@SuppressLint("UnrememberedMutableState")
//@Preview(showBackground = true)
//@Composable
//private fun Preview() {
//    PointsPopupWindow(earnPoints = "+15", {})
//}

@Composable
fun ScreenGame(
    departureArguments: String?,
    navController: NavController,
    viewModel: ScreenGameViewModel
) {
    viewModel.initArguments(departureArguments)


    val model by viewModel.model.collectAsState()

    model.navigationEvent?.use { route ->
        when (route) {
            ScreenGameViewModel.Model.NavigationSingleLifeEvent.NavigationDestination.ScreenMain ->
                navController.navigate(SCREEN_MAIN)

            ScreenGameViewModel.Model.NavigationSingleLifeEvent.NavigationDestination.ScreenInfo ->
                navController.navigate("ScreenInfo/${model.drumIconNeedToShowLeft}_${model.drumIconNeedToShowCenter}_${model.drumIconNeedToShowRight}_screengame")
        }
    }

    val listDrumIcons = remember {
        listOf(
            com.andreykosarygin.game_ui.R.drawable.slot_machine_icon_bar,
            com.andreykosarygin.game_ui.R.drawable.slot_machine_icon_jackpot,
            com.andreykosarygin.game_ui.R.drawable.slot_machine_icon_cherry,
            com.andreykosarygin.game_ui.R.drawable.slot_machine_icon_apple,
            com.andreykosarygin.game_ui.R.drawable.slot_machine_icon_bonus,
            com.andreykosarygin.game_ui.R.drawable.slot_machine_icon_coin,
            com.andreykosarygin.game_ui.R.drawable.slot_machine_icon_crown,
            com.andreykosarygin.game_ui.R.drawable.slot_machine_icon_lemon,
            com.andreykosarygin.game_ui.R.drawable.slot_machine_icon_seven,
            com.andreykosarygin.game_ui.R.drawable.slot_machine_icon_symbol,
            com.andreykosarygin.game_ui.R.drawable.slot_machine_icon_watermelon,
            com.andreykosarygin.game_ui.R.drawable.slot_machine_icon_wild,
        )
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        LuckyLottoCommonBackground(onClickBackArrow = {
            viewModel.buttonBackPressed()
        })

        ButtonInfo(onClickInfo = {
            viewModel.buttonInfoPressed()
        })

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.TopCenter
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                PointsValue(balance = model.pointsBalance)

                Header(
                    modifier = Modifier.padding(top = 14.dp, bottom = 33.dp)
                )

                SlotMachine(
                    playAnimation = model.playAnimation,
                    whatIndexNeedToShowLeft = model.drumIconNeedToShowLeft,
                    whatIndexNeedToShowCenter = model.drumIconNeedToShowCenter,
                    whatIndexNeedToShowRight = model.drumIconNeedToShowRight,
                    listDrumIcons = listDrumIcons,
                    animationFinishedListener = {
                        viewModel.animationFinished()
                    }
                )

                LuckyLottoButton(
                    text = stringResource(id = R.string.spin),
                    onClick = {
                        viewModel.buttonSpinPressed(listDrumIcons.size)
                    },
                    paddingValues = PaddingValues(top = 93.dp)
                )
            }
        }
        AnimatedVisibility(
            visible = model.showPopupWindow,
            enter = fadeIn(
                animationSpec = tween(delayMillis = 2000)
            ),
            exit = fadeOut()
        ) {
            PointsPopupWindow(
                earnPoints = model.earnPoints,
                onClickButtonRespin = {
                    viewModel.buttonRespinPressed()
                }
            )
        }
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

@Composable
fun SlotMachine(
    playAnimation: Boolean,
    whatIndexNeedToShowLeft: Int,
    whatIndexNeedToShowCenter: Int,
    whatIndexNeedToShowRight: Int,
    listDrumIcons: List<Int>,
    animationFinishedListener: () -> Unit
) {
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

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(width = 274.dp, height = 105.dp)
                .offset(x = -(12).dp, y = -(15.5).dp)
        ) {
            Drum(
                playDrumAnimation = playAnimation,
                whatIndexNeedToShowLeft = whatIndexNeedToShowLeft,
                whatIndexNeedToShowCenter = whatIndexNeedToShowCenter,
                whatIndexNeedToShowRight = whatIndexNeedToShowRight,
                animationFinishedListener = animationFinishedListener,
                listDrumIcons = listDrumIcons
            )
        }
    }
}

@Composable
fun Drum(
    playDrumAnimation: Boolean,
    whatIndexNeedToShowLeft: Int,
    whatIndexNeedToShowCenter: Int,
    whatIndexNeedToShowRight: Int,
    animationFinishedListener: () -> Unit,
    easingElementsCount: Int = 5,
    minimumDurationMillis: Int = 100,
    minimumShownElementsLeft: Int = 20,
    minimumShownElementsCenter: Int = 30,
    minimumShownElementsRight: Int = 48,
    listDrumIcons: List<Int>
) {
    var needToStartAnimation by remember { mutableStateOf(true) }

    var playDrumAnimationLeft by remember { mutableStateOf(false) }
    var playDrumAnimationCenter by remember { mutableStateOf(false) }
    var playDrumAnimationRight by remember { mutableStateOf(false) }

    if (playDrumAnimation && needToStartAnimation) {
        playDrumAnimationLeft = true
        playDrumAnimationCenter = true
        playDrumAnimationRight = true
    }

    DrumSectionLeft(
        animationStartState = playDrumAnimationLeft,
        whatIndexNeedToShow = whatIndexNeedToShowLeft,
        listOfDrawableResId = listDrumIcons,
        finishedListener = {
            needToStartAnimation = false
            playDrumAnimationLeft = false
        },
        easingElementsCount = easingElementsCount,
        minimumDurationMillis = minimumDurationMillis,
        minimumShownElements = minimumShownElementsLeft
    )

    DrumSectionCenter(
        animationStartState = playDrumAnimationCenter,
        whatIndexNeedToShow = whatIndexNeedToShowCenter,
        listOfDrawableResId = listDrumIcons,
        finishedListener = {
            needToStartAnimation = false
            playDrumAnimationCenter = false
        },
        easingElementsCount = easingElementsCount,
        minimumDurationMillis = minimumDurationMillis,
        minimumShownElements = minimumShownElementsCenter
    )

    DrumSectionRight(
        animationStartState = playDrumAnimationRight,
        whatIndexNeedToShow = whatIndexNeedToShowRight,
        listOfDrawableResId = listDrumIcons,
        finishedListener = {
            playDrumAnimationRight = false
            animationFinishedListener()
            needToStartAnimation = true
        },
        easingElementsCount = easingElementsCount,
        minimumDurationMillis = minimumDurationMillis,
        minimumShownElements = minimumShownElementsRight
    )
}

@Composable
fun DrumSectionLeft(
    animationStartState: Boolean,
    whatIndexNeedToShow: Int,
    listOfDrawableResId: List<Int>,
    finishedListener: () -> Unit,
    easingElementsCount: Int = 5,
    minimumDurationMillis: Int = 100,
    minimumShownElements: Int = 30
) {
    Box(
        modifier = Modifier
            .size(width = 72.dp, height = 105.dp)
            .offset(x = -(88).dp)
            .clipToBounds(),
        contentAlignment = Alignment.Center
    ) {
        SlotMachineDrumAnimation(
            animationStartState = animationStartState,
            whatIndexNeedToShow = whatIndexNeedToShow,
            minimumShownElements = minimumShownElements,
            sizeOfBox = 72.dp,
            sizeOfInnerBox = 72.dp,
            listOfDrawableResId = listOfDrawableResId,
            finishedListener = finishedListener,
            easingElementsCount = easingElementsCount,
            minimumDurationMillis = minimumDurationMillis
        )
    }
}

@Composable
fun DrumSectionCenter(
    animationStartState: Boolean,
    whatIndexNeedToShow: Int,
    listOfDrawableResId: List<Int>,
    finishedListener: () -> Unit,
    easingElementsCount: Int = 5,
    minimumDurationMillis: Int = 100,
    minimumShownElements: Int = 30
) {
    Box(
        modifier = Modifier
            .size(width = 72.dp, height = 105.dp)
            .offset(x = -(1).dp)
            .clipToBounds(),
        contentAlignment = Alignment.Center
    ) {
        SlotMachineDrumAnimation(
            animationStartState = animationStartState,
            whatIndexNeedToShow = whatIndexNeedToShow,
            minimumShownElements = minimumShownElements,
            sizeOfBox = 72.dp,
            sizeOfInnerBox = 72.dp,
            listOfDrawableResId = listOfDrawableResId,
            finishedListener = finishedListener,
            easingElementsCount = easingElementsCount,
            minimumDurationMillis = minimumDurationMillis
        )
    }
}

@Composable
fun DrumSectionRight(
    animationStartState: Boolean,
    whatIndexNeedToShow: Int,
    listOfDrawableResId: List<Int>,
    finishedListener: () -> Unit,
    easingElementsCount: Int = 5,
    minimumDurationMillis: Int = 100,
    minimumShownElements: Int = 30
) {
    Box(
        modifier = Modifier
            .size(width = 72.dp, height = 105.dp)
            .offset(x = 85.dp)
            .clipToBounds(),
        contentAlignment = Alignment.Center
    ) {
        SlotMachineDrumAnimation(
            animationStartState = animationStartState,
            whatIndexNeedToShow = whatIndexNeedToShow,
            minimumShownElements = minimumShownElements,
            sizeOfBox = 72.dp,
            sizeOfInnerBox = 72.dp,
            listOfDrawableResId = listOfDrawableResId,
            finishedListener = finishedListener,
            easingElementsCount = easingElementsCount,
            minimumDurationMillis = minimumDurationMillis
        )
    }
}

@Composable
fun SlotMachineDrumAnimation(
    animationStartState: Boolean,
    whatIndexNeedToShow: Int,
    minimumShownElements: Int,
    easingElementsCount: Int = 5,
    minimumDurationMillis: Int = 100,
    sizeOfBox: Dp,
    sizeOfInnerBox: Dp,
    listOfDrawableResId: List<Int>,
    finishedListener: () -> Unit,
    previewDrawableResId: Int = listOfDrawableResId[whatIndexNeedToShow]
) {
    val animationTargetValue = sizeOfInnerBox + ((sizeOfBox - sizeOfInnerBox) / 2)

    var playAnimation by remember { mutableStateOf(animationStartState) }
    playAnimation = animationStartState
    var animationIsRunning by remember { mutableStateOf(false) }

    var targetValue by remember { mutableStateOf(0.dp) }
    var durationMillis by remember { mutableStateOf(minimumDurationMillis) }

    var selectedItemIndex by remember { mutableStateOf(0) }
    var drawableResId by remember { mutableStateOf(previewDrawableResId) }

    var counterShownElements by remember { mutableStateOf(0) }

    var targetFastShownElements by remember { mutableStateOf(0) }


    val offsetAnimated by animateDpAsState(
        targetValue = targetValue,
        animationSpec = tween(
            durationMillis = durationMillis,
            easing = LinearEasing
        ),
        finishedListener = {
            if (playAnimation) {
                if (durationMillis == 0) {
                    if (counterShownElements > targetFastShownElements) {
                        if ((counterShownElements - targetFastShownElements) < easingElementsCount) {
                            durationMillis =
                                minimumDurationMillis * (counterShownElements - targetFastShownElements)
                            targetValue = animationTargetValue
                        } else {
                            durationMillis =
                                minimumDurationMillis * (counterShownElements - targetFastShownElements)
                            targetValue = 0.dp
                            playAnimation = false
                            animationIsRunning = false
                            counterShownElements = 0
                            finishedListener()
                        }

                    } else {
                        durationMillis = minimumDurationMillis
                        targetValue = animationTargetValue
                    }
                } else {
                    durationMillis = 0
                    targetValue = -(animationTargetValue)

                    selectedItemIndex =
                        if (selectedItemIndex != listOfDrawableResId.lastIndex) selectedItemIndex + 1 else 0
                    drawableResId = listOfDrawableResId[selectedItemIndex]
                    counterShownElements += 1
                }
            }
        }
    )

    if (playAnimation) {
        if (!animationIsRunning) {
            targetFastShownElements =
                (((((minimumShownElements / listOfDrawableResId.size) + (if (minimumShownElements % listOfDrawableResId.size > 0) 1 else 0)) * listOfDrawableResId.size) + whatIndexNeedToShow) - easingElementsCount) - selectedItemIndex
            durationMillis = minimumDurationMillis
            targetValue = animationTargetValue
            animationIsRunning = true
        }
    }

    Box(
        modifier = Modifier
            .size(size = sizeOfBox)
            .clipToBounds(),
        contentAlignment = Alignment.Center
    ) {
        Box(
            Modifier
                .offset(y = offsetAnimated)
                .size(size = sizeOfInnerBox)
        ) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(id = drawableResId),
                contentScale = ContentScale.Fit,
                contentDescription = ""
            )
        }
    }
}

@Composable
private fun PointsPopupWindow(
    earnPoints: String,
    onClickButtonRespin: () -> Unit
) {
    Box(
        modifier = Modifier
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        colorResource(id = R.color.lucky_lotto_dark_red),
                        colorResource(id = R.color.lucky_lotto_dark_red)
                    )
                ),
                alpha = (0.62f)
            )
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .offset(x = 9.dp)
                    .padding(bottom = 100.dp)
            ) {
                Image(
                    modifier = Modifier.size(size = 258.dp),
                    painter = painterResource(id = com.andreykosarygin.game_ui.R.drawable.background_earn_points),
                    contentDescription = stringResource(
                        id = R.string.content_description_background_points
                    )
                )
                LuckyLottoWhiteText(
                    text = earnPoints,
                    fontSize = 79.32.sp,
                    font = Font(resId = R.font.bitter_900)
                )
            }

            LuckyLottoButton(
                text = stringResource(id = R.string.respin),
                onClick = onClickButtonRespin
            )
        }
    }
}
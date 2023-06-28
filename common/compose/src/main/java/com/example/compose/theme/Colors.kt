package com.example.compose.theme

import androidx.compose.material.darkColors
import androidx.compose.ui.graphics.Color

val blackText = Color(0xFF212121)
val grayText = Color(0xFF616161)
val redNegative = Color(0xFFC4314B)
val greenPositive = Color(0xFF237B4B)
val pureWhite = Color(0xFFFFFFFF)
val secondaryPurple = Color(0xFF828EC6)
val transparent = Color(0x00000000)
val grayDarker = Color(0xFF49454F)
val violetIndicator = Color(0xFF5B5FC7)
val grayTabText = Color(0xFF818C99)
val lightTabBar = Color(0xFF99A2AD)


val DarkColorPalette = darkColors(
    primary = blackText,
    primaryVariant = grayText,
    secondary = secondaryPurple,
    background = pureWhite,
    surface = pureWhite,
)

val LightColorPalette = darkColors(
    primary = blackText,
    primaryVariant = grayText,
    secondary = secondaryPurple,
    background = pureWhite,
    surface = pureWhite,
)


//val DarkColorPalette = darkColors(
//    primary = blackText,
//    primaryVariant = grayText,
//    secondary = yellow,
//    onPrimary = blue,
//    background = pureWhite,
//    onBackground = blue,
//    surface = pureWhite,
//    onSurface = blue
//)
//
//
//val LightColorPalette = lightColors(
//    primary = blackText,
//    primaryVariant = grayText,
//    secondary = yellow,
//    onPrimary = blue,
//    background = pureWhite,
//    onBackground = blue,
//    surface = pureWhite,
//    onSurface = blue
//)
//
//fun Colors.actionGreen(): Color = green
//fun Colors.labelRed(): Color = red
//fun Colors.labelYellow(): Color = yellow
//
//fun Colors.button1Text(): Color = if (isLight) blue else blue
//fun Colors.button2Text(): Color = if (isLight) gray else gray


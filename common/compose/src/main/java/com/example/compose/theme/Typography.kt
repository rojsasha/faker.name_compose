package com.example.compose.theme

import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val lightThemeTypography = Typography(
    defaultFontFamily = fontRoboto,
    h1 = TextStyle(
        color = blackText,
        fontWeight = FontWeight.Bold,
        fontSize = 28.sp
    ),
    h2 = TextStyle(
        color = blackText,
        fontWeight = FontWeight.Medium,
        fontSize = 20.sp
    ),
    h3 = TextStyle(
        color = blackText,
        fontWeight = FontWeight.Medium,
        fontSize = 18.sp
    ),
    h4 = TextStyle(
        color = blackText,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp
    ),
    h5 = TextStyle(
        color = blackText,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
    ),
    body1 = TextStyle(
        color = grayText,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    body2 = TextStyle(
        color = blackText,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    )
)

val darkThemeTypography = Typography(
    defaultFontFamily = fontRoboto,
    h1 = TextStyle(
        color = blackText,
        fontWeight = FontWeight.Bold,
        fontSize = 28.sp
    ),
    h2 = TextStyle(
        color = blackText,
        fontWeight = FontWeight.Medium,
        fontSize = 20.sp
    ),
    h3 = TextStyle(
        color = blackText,
        fontWeight = FontWeight.Medium,
        fontSize = 18.sp
    ),
    h4 = TextStyle(
        color = blackText,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp
    ),
    h5 = TextStyle(
        color = blackText,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
    ),
    body1 = TextStyle(
        color = grayText,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    body2 = TextStyle(
        color = blackText,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    )
)

class ExecutorAppTypography(colors: Colors) {
    private val primaryTextColor = colors.primary
    private val secondaryTextColor = colors.primaryVariant

    val bold28Primary = TextStyle(
        color = primaryTextColor,
        fontWeight = FontWeight.Bold,
        fontSize = 28.sp
    )

    val bold20Primary = TextStyle(
        color = primaryTextColor,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
    )

    val medium20Primary = TextStyle(
        color = primaryTextColor,
        fontWeight = FontWeight.Medium,
        fontSize = 20.sp
    )

    val medium18Primary = TextStyle(
        color = primaryTextColor,
        fontWeight = FontWeight.Medium,
        fontSize = 18.sp
    )

    val bold16Primary = TextStyle(
        color = primaryTextColor,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp
    )

    val normal14Primary = TextStyle(
        color = primaryTextColor,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    )

    val normal14Secondary = TextStyle(
        color = secondaryTextColor,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    )
}

@Composable
fun MaterialTheme.appTypography(): ExecutorAppTypography {
    return ExecutorAppTypography(this.colors)
}


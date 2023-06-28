package com.example.compose.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import com.example.compose.theme.DarkColorPalette
import com.example.compose.theme.LightColorPalette

@Composable
fun FakerTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    val typography = if (darkTheme) {
        darkThemeTypography
    } else {
        lightThemeTypography
    }

    MaterialTheme(
        colors = colors,
        typography = typography,
        content = content
    )
}

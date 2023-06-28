package com.example.compose.theme

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.example.compose.R

val fontRoboto = FontFamily(
    Font(R.font.roboto_bold, weight = FontWeight.Bold),
    Font(R.font.roboto_medium, weight = FontWeight.Medium),
    Font(R.font.roboto_regular, weight = FontWeight.Normal),
    Font(R.font.roboto_light, weight = FontWeight.Light),
    Font(R.font.roboto_thin, weight = FontWeight.Thin)
)

val fontRaleWay = FontFamily(
    Font(R.font.raleway_semibold, weight = FontWeight.SemiBold),
    Font(R.font.raleway_medium, weight = FontWeight.Medium)
)

val fontSFProDisplay = FontFamily(
    Font(R.font.sf_pro_regular, weight = FontWeight.Normal)
)
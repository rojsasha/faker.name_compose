package com.example.yana.fakername.ui.components

import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.theme.*
import com.example.yana.fakername.R


@Preview
@Composable
fun BlackButton(@StringRes text: Int = R.string.search_txt, onClick: () -> Unit = {}) {
    Button(
        onClick = { onClick.invoke() },
        colors = ButtonDefaults.buttonColors(backgroundColor = blackText),
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .height(48.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = stringResource(text),
            color = pureWhite,
            fontFamily = fontRaleWay,
            fontSize = 16.sp,
            letterSpacing = 0.01.sp
        )
    }
}

@Preview
@Composable
fun TransparentButton(@StringRes text: Int = R.string.registration_txt, onClick: () -> Unit = {}) {
    Button(
        onClick = { onClick.invoke() },
        colors = ButtonDefaults.buttonColors(backgroundColor = transparent),
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(1.dp, secondaryPurple),
        modifier = Modifier
            .height(48.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = stringResource(text),
            color = blackText,
            fontFamily = fontRaleWay,
            fontSize = 16.sp,
            letterSpacing = 0.01.sp
        )
    }

}
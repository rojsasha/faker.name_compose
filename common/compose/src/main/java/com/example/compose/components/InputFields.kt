package com.example.compose.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.compose.theme.grayDarker
import com.example.compose.theme.grayText
import com.example.compose.theme.redNegative
import com.example.compose.theme.secondaryPurple
import com.example.compose.R

@Preview
@Composable
fun TransparentTextField(
    @StringRes label: Int = R.string.inn_or_pin,
    input: (String) -> Unit = {}
) {
    val text = remember { mutableStateOf(TextFieldValue("")) }
    OutlinedTextField(
        text.value,
        {
            text.value = it
            input.invoke(it.text)
        },
        label = { Text(text = stringResource(label)) },
        modifier = Modifier.fillMaxWidth(),
        textStyle = TextStyle(fontSize = 16.sp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = secondaryPurple,
            unfocusedBorderColor = grayText,
            errorBorderColor = redNegative,
            textColor = grayDarker,
            cursorColor = secondaryPurple,
            focusedLabelColor = secondaryPurple
        )
    )
}
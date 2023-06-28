package com.example.yana.fakername.ui.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.compose.theme.grayDarker
import com.example.compose.theme.grayText
import com.example.compose.theme.redNegative
import com.example.compose.theme.secondaryPurple
import com.example.yana.fakername.R

@Preview
@Composable
fun TransparentTextField(@StringRes label: Int = R.string.inn_or_pin) {
    val text = remember { mutableStateOf(TextFieldValue("")) }
    OutlinedTextField(
        text.value,
        { text.value = it },
        label = { Text(text = "ИНН или ПИН") },
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

@OptIn(ExperimentalMaterialApi::class)
@Preview
@Composable
fun ExposedDropdownMenuBox1() {
    val options = listOf("Выберите страну", "Bill Payment", "Recharges", "Outing", "Other")
    val expanded = remember { mutableStateOf(false) }
    val selectedOptionText = remember { mutableStateOf(options[0]) }
    ExposedDropdownMenuBox(
        expanded = expanded.value,
        onExpandedChange = {
            expanded.value = !expanded.value
        }
    ){
        OutlinedTextField(
            selectedOptionText.value,
            {  },


            modifier = Modifier.fillMaxWidth(),
            readOnly = true,
            textStyle = TextStyle(fontSize = 16.sp),
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(
                    expanded = expanded.value
                )
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = grayText,
                unfocusedBorderColor = grayText,
                errorBorderColor = redNegative,
                textColor = grayDarker,
                cursorColor = secondaryPurple,
                focusedLabelColor = secondaryPurple
            )
        )
        ExposedDropdownMenu(
            expanded = expanded.value,
            onDismissRequest = {
                expanded.value = false
            }
        ) {
            options.forEach { selectionOption ->
                DropdownMenuItem(
                    onClick = {
                        selectedOptionText.value = selectionOption
                        expanded.value = false
                    }
                ) {
                    Text(text = selectionOption)
                }
            }
        }
    }
}
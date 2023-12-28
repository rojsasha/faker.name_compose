package com.example.search

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.components.BlackButton
import com.example.compose.components.H1TextView
import com.example.compose.components.TransparentTextField
import com.example.compose.theme.grayDarker
import com.example.compose.theme.grayText
import com.example.compose.theme.pureWhite
import com.example.compose.theme.redNegative
import com.example.compose.theme.secondaryPurple
import com.example.model.Countries
import com.example.search.vm.SearchViewModel

@Composable
internal fun SearchScreen(viewModel: SearchViewModel) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding(),
        color = pureWhite
    ) {
        val viewState = viewModel.countriesList.collectAsState()
        Column(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
                .padding(horizontal = 16.dp)
        ) {
            Spacer(modifier = Modifier.padding(top = 40.dp))
            H1TextView()
            Spacer(modifier = Modifier.padding(top = 20.dp))
            ExposedDropdownMenuBox1(viewState)
            Spacer(modifier = Modifier.padding(top = 32.dp))
            TransparentTextField(){}
            Spacer(modifier = Modifier.padding(top = 44.dp))
            BlackButton()
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ExposedDropdownMenuBox1(viewState: State<List<Countries>>) {
    val options = viewState.value.map { it.name }
    val expanded = remember { mutableStateOf(false) }
    val selectedOptionText = remember { mutableStateOf(options.firstOrNull()) }
    ExposedDropdownMenuBox(
        expanded = expanded.value,
        onExpandedChange = {
            expanded.value = !expanded.value
        }
    ) {
        OutlinedTextField(
            selectedOptionText.value ?: "Выберите страну",
            { },
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
                    Text(text = selectionOption?:"")
                }
            }
        }
    }
}
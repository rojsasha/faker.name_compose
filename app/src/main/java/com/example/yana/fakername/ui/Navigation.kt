package com.example.yana.fakername.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.compose.theme.secondaryPurple
import com.example.yana.fakername.ui.new_app_package.AppNavigation
import com.example.yana.fakername.ui.new_app_package.Navigate
import com.example.yana.fakername.ui.new_app_package.bottom_bar.BottomBar
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.google.accompanist.navigation.material.ModalBottomSheetLayout
import com.google.accompanist.navigation.material.rememberBottomSheetNavigator

@OptIn(ExperimentalAnimationApi::class, ExperimentalMaterialNavigationApi::class)
@Composable
internal fun MainScreen(onLauncherFinished: () -> Unit) {
    val bottomSheetNavigator = rememberBottomSheetNavigator()
    val navController = rememberAnimatedNavController(bottomSheetNavigator)
    val bottomBarState = rememberSaveable {
        (mutableStateOf(false))
    }

    ModalBottomSheetLayout(
        bottomSheetNavigator = bottomSheetNavigator,
        sheetShape = BottomSheetShape,
        sheetBackgroundColor = Color.Transparent
    ) {
        Scaffold(
            backgroundColor = MaterialTheme.colors.surface,
            bottomBar = {
                BottomBar(navController, bottomBarState)
            },
            floatingActionButton = {
                AnimatedVisibility(
                    visible = bottomBarState.value,
                    enter = slideInVertically(initialOffsetY = { it }),
                    exit = slideOutVertically(targetOffsetY = { it })
                ) {
                    FloatingActionButton(
                        onClick = { /*TODO*/ },
                        elevation = FloatingActionButtonDefaults.elevation(4.dp),
                        backgroundColor = secondaryPurple,
                        contentColor = MaterialTheme.colors.onPrimary,
                        shape = RoundedCornerShape(50),
                    ) {
                        Icon(imageVector = Icons.Default.Add, contentDescription = "Add")
                    }
                }
            },
            floatingActionButtonPosition = FabPosition.Center,
            isFloatingActionButtonDocked = true,
        ) {
            BoxWithConstraints(
                modifier = Modifier.fillMaxSize()
            ) {
                AppNavigation(
                    navController = navController,
                    startDestination = Navigate.Screen.Search.route,
                    width = constraints.maxWidth / 2,
                    bottomBarPadding = it,
                    bottomBarState = bottomBarState
                )
            }
        }
    }
}

val BottomSheetShape = RoundedCornerShape(
    topStart = 20.dp,
    topEnd = 20.dp,
    bottomEnd = 0.dp,
    bottomStart = 0.dp
)


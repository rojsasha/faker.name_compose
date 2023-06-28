package com.example.yana.fakername.ui.new_app_package

import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.example.compose.theme.pureWhite
import com.example.search.SearchMainScreen
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AppNavigation(
    navController: NavHostController,
    startDestination: String,
    width: Int,
    bottomBarPadding: PaddingValues,
    bottomBarState: MutableState<Boolean>
) {
    AnimatedNavHost(
        navController = navController,
        startDestination = startDestination,
        builder = {
            mainScreenScreen(navController, width, bottomBarPadding, bottomBarState)
            profileScreen(navController, width, bottomBarPadding, bottomBarState)
        }
    )
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.mainScreenScreen(
    navController: NavController,
    width: Int,
    bottomBarPadding: PaddingValues,
    bottomBarState: MutableState<Boolean>
) {
    composable(
        route = Navigate.Screen.Search.route,
        enterTransition = {
            slideIntoContainer(AnimatedContentScope.SlideDirection.Left, animationSpec = tween(200))
        },
        exitTransition = {
            slideOutOfContainer(
                AnimatedContentScope.SlideDirection.Left,
                animationSpec = tween(200)
            )
        },
        popEnterTransition = {
            slideIntoContainer(
                AnimatedContentScope.SlideDirection.Right,
                animationSpec = tween(200)
            )
        },
        popExitTransition = {
            slideOutOfContainer(
                AnimatedContentScope.SlideDirection.Right,
                animationSpec = tween(200)
            )
        }
    ) { entry ->
        bottomBarState.value = true
        val systemUiController = rememberSystemUiController()
        SideEffect {
            systemUiController.setStatusBarColor(
                color = pureWhite,
                darkIcons = true
            )
            systemUiController.setNavigationBarColor(
                color = pureWhite,
                darkIcons = true
            )
        }
        val activity = (LocalContext.current as? Activity)

        BackHandler(true) {
            activity?.finish()
        }

        SearchMainScreen(
            navController,
            entry.arguments?.getString("query")
        ) {
            navController.navigate(Navigate.Screen.Details.route + "/$it")
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.profileScreen(
    navController: NavController,
    width: Int,
    bottomBarPadding: PaddingValues,
    bottomBarState: MutableState<Boolean>
) {
    composable(
        route = Navigate.Screen.Profile.route,
        enterTransition = {
            slideIntoContainer(AnimatedContentScope.SlideDirection.Left, animationSpec = tween(200))
        },
        exitTransition = {
            slideOutOfContainer(
                AnimatedContentScope.SlideDirection.Left,
                animationSpec = tween(200)
            )
        },
        popEnterTransition = {
            slideIntoContainer(
                AnimatedContentScope.SlideDirection.Right,
                animationSpec = tween(200)
            )
        },
        popExitTransition = {
            slideOutOfContainer(
                AnimatedContentScope.SlideDirection.Right,
                animationSpec = tween(200)
            )
        }
    ) {
        bottomBarState.value = true
        val systemUiController = rememberSystemUiController()
        SideEffect {
            systemUiController.setStatusBarColor(
                color = pureWhite,
                darkIcons = true
            )
            systemUiController.setNavigationBarColor(
                color = pureWhite,
                darkIcons = true
            )
        }
        val activity = (LocalContext.current as? Activity)

        BackHandler(true) {
            activity?.finish()
        }
        SearchMainScreen(navController, it.arguments?.getString("query")) {
            navController.navigate(Navigate.Screen.Details.route + "/$it")
        }
    }
}
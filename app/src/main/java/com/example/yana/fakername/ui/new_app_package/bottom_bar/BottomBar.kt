package com.example.yana.fakername.ui.new_app_package.bottom_bar

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.compose.theme.lightTabBar
import com.example.compose.theme.pureWhite
import com.example.compose.theme.secondaryPurple

@Composable
fun BottomBar(
    navController: NavHostController,
    bottomBarState: MutableState<Boolean>
) {

    AnimatedVisibility(
        visible = bottomBarState.value,
        enter = slideInVertically(initialOffsetY = { it }),
        exit = slideOutVertically(targetOffsetY = { it })
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
        BottomAppBar(
            modifier = Modifier.navigationBarsPadding(),
            backgroundColor = pureWhite,
        ) {
            screens.forEach { screen ->
                AddItem(
                    screen = screen,
                    currentDestination = currentDestination,
                    navController = navController
                )
            }
        }
//        CompositionLocalProvider(
//            LocalLayoutDirection provides
//                    if (LocalConfiguration.current.layoutDirection == LayoutDirection.Rtl.ordinal) {
//                        LayoutDirection.Rtl
//                    } else {
//                        LayoutDirection.Ltr
//                    }
//        ) {
//            BottomAppBar(
//                modifier = Modifier.navigationBarsPadding(),
//                backgroundColor = pureWhite,
//            ) {
//                screens.forEach { screen ->
//                    AddItem(
//                        screen = screen,
//                        currentDestination = currentDestination,
//                        navController = navController
//                    )
//                }
//            }
//        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: NavigationModel,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    BottomNavigationItem(
        label = {
            if (screen != NavigationModel.Invisible)
                Text(
                    text = stringResource(id = screen.title),
                    style = MaterialTheme.typography.caption,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
        },
        icon = {
            if (screen != NavigationModel.Invisible)
                Icon(painter = painterResource(screen.icon), contentDescription = null)
        },
        enabled = screen != NavigationModel.Invisible,
        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
        unselectedContentColor = lightTabBar,
        selectedContentColor = secondaryPurple,
        onClick = {
            if (currentDestination?.hierarchy?.any { it.route == screen.route } == false) {
                navController.navigate(screen.route) {
                    popUpTo(navController.graph.findStartDestination().id) { }
                    launchSingleTop = true
                }
            }
        }
    )
}

val screens = listOf(
    NavigationModel.Search,
    NavigationModel.Invisible,
    NavigationModel.Profile,
)
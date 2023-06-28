package com.example.yana.fakername.ui.new_app_package.bottom_bar

import androidx.annotation.StringRes
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import com.example.yana.fakername.R
import com.example.yana.fakername.ui.new_app_package.Navigate

sealed class NavigationModel(
    val route: String,
    @StringRes val title: Int,
    val icon: Int
) {
    object Search : NavigationModel(
        route = Navigate.Screen.Search.route,
        title = R.string.main,
        icon = R.drawable.home_icon
    )

    object Profile : NavigationModel(
        route = Navigate.Screen.Profile.route,
        title = R.string.profile,
        icon = R.drawable.profile_icon
    )

    object Invisible : NavigationModel(
        route = Navigate.Screen.Profile.route,
        title = R.string.profile,
        icon = R.drawable.profile_icon
    )
}
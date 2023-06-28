package com.example.yana.fakername.ui.new_app_package

sealed class Navigate(val route: String) {

    sealed class BottomSheet {

        object Ingredients : Navigate("ingredients_details")
    }

    sealed class Screen {
        object Search : Navigate("search_screen")
        object Profile : Navigate("profile_screen")
        object Details : Navigate("details_screen")
    }
}
package com.huertohogar.core.navigation

sealed class Screen(val route: String) {
    object Login : Screen("login")
    object Dashboard : Screen("dashboard")
    object GardenForm : Screen("gardenform")
    object Map : Screen("map")
    object History : Screen("history")
    object Settings : Screen("settings")
}
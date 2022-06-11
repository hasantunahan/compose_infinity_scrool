package com.example.compose_marvel._product.config.navigation

sealed class NavRoutes(val route: String) {
    object Home : NavRoutes("home")
    object Splash : NavRoutes("splash")
}
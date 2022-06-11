package com.example.compose_marvel._product.config.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.compose_marvel.view.home.HomeScreen
import com.example.compose_marvel.view.splash.SplashScreen

@Composable
fun NavigationBuilder() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavRoutes.Splash.route,
    ) {

        composable(NavRoutes.Splash.route) {
            SplashScreen(navController = navController)
        }

        composable(NavRoutes.Home.route) {
            HomeScreen(navController = navController)
        }
    }
}

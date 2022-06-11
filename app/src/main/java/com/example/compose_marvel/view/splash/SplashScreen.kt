package com.example.compose_marvel.view.splash

import android.os.Handler
import android.os.Looper
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.compose_marvel.R
import com.example.compose_marvel._product.config.navigation.NavRoutes
import com.example.compose_marvel.core.component.image.ImageAsset

@Composable
fun SplashScreen(navController: NavController) {

    Thread(Runnable {
        Handler(Looper.getMainLooper()).postDelayed(Runnable {
            navController.navigate(NavRoutes.Home.route)
        }, 2500)
    }).start()

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            ImageAsset(_id = R.drawable.marvel_logo, _width = null, _height = null)

        }
    }

}



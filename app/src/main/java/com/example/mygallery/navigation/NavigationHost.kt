package com.example.mygallery.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mygallery.ui.screens.MainScreen
import com.example.mygallery.ui.screens.SplashScreen

@Composable
fun NavigationHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = "splash_screen"
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable("splash_screen") {
            SplashScreen(navController = navController)
        }
        composable("main_screen") {
            MainScreen()
        }
    }
}
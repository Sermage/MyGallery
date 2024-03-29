package com.sermage.mygallery.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sermage.mygallery.ui.screens.main.MainScreen
import com.sermage.mygallery.ui.screens.search.SearchScreen
import com.sermage.mygallery.ui.screens.splash.SplashScreen

const val SPLASH_SCREEN_ROUTE = "splash_screen"
const val MAIN_SCREEN_ROUTE = "main_screen"
const val SEARCH_SCREEN_ROUTE = "search_screen"

@Composable
fun NavigationHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = SPLASH_SCREEN_ROUTE,
    googleAssistantQuery: String? = null
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(SPLASH_SCREEN_ROUTE) {
            SplashScreen(
                googleAssistantQuery = googleAssistantQuery,
                navigateToMainScreen = {
                    navController.navigate(MAIN_SCREEN_ROUTE) {
                        launchSingleTop = true
                        popUpTo(SPLASH_SCREEN_ROUTE) { inclusive = true }
                    }
                },
            )
        }
        composable(MAIN_SCREEN_ROUTE) {
            MainScreen(
                backClick = { navController.popBackStack() },
                onSearchButtonClick = { navController.navigate(SEARCH_SCREEN_ROUTE) }
            )
        }
        composable(SEARCH_SCREEN_ROUTE) {
            SearchScreen(googleAssistantQuery)
        }
    }
}
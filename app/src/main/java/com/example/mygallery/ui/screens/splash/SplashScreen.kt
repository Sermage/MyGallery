package com.example.mygallery.ui.screens.splash

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.mygallery.R
import com.example.mygallery.navigation.MAIN_SCREEN_ROUTE
import com.example.mygallery.ui.theme.MyGalleryTheme
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    LaunchedEffect(key1 = Unit) {
        delay(2000L)
        navController.navigate(MAIN_SCREEN_ROUTE)
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.background)
    ) {
        Image(
            painter = painterResource(id = R.drawable.splash_logo_bg),
            contentDescription = "Logo background"
        )
        Image(
            painter = painterResource(id = R.drawable.ic_surf_logo),
            contentDescription = "Logo"
        )
        Image(
            painter = painterResource(id = R.drawable.ic_logo_android),
            contentDescription = "android logo",
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 24.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    MyGalleryTheme {
        SplashScreen(rememberNavController())
    }
}

@Preview(
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES,
    name = "SplashScreenDark",
)
@Composable
fun SplashScreenDarkPreview() {
    MyGalleryTheme(darkTheme = true) {
        SplashScreen(rememberNavController())
    }
}
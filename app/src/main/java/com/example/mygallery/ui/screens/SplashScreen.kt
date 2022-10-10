package com.example.mygallery.ui.screens

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mygallery.R
import com.example.mygallery.ui.theme.MyGalleryTheme

@Composable
fun SplashScreen(modifier: Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
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
            modifier = modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 24.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    MyGalleryTheme {
        SplashScreen(modifier = Modifier)
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
        SplashScreen(modifier = Modifier)
    }
}
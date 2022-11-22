package com.sermage.mygallery.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val DarkColorPalette = darkColors(
    primary = Green,
    primaryVariant = Purple700,
    secondary = Green,
    background = Haiti,
    surface = Black,
    onSurface = White
)

private val LightColorPalette = lightColors(
    primary = Green,
    primaryVariant = Purple700,
    secondary = Green,
    background = White,
    surface = Cream,
    onSurface = Haiti
)

@Composable
fun MyGalleryTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )

    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(colors.background, darkIcons = !darkTheme)
}
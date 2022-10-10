package com.example.mygallery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.example.mygallery.ui.screens.SplashScreen
import com.example.mygallery.ui.theme.MyGalleryTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyGalleryTheme {
                Surface {
                    SplashScreen(modifier = Modifier)
                }
            }
        }
    }
}


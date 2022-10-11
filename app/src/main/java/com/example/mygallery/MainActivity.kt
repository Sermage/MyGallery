package com.example.mygallery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.mygallery.navigation.NavigationHost
import com.example.mygallery.ui.theme.MyGalleryTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyGalleryTheme {
                NavigationHost()
            }
        }
    }
}


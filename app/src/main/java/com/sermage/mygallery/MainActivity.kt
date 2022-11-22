package com.sermage.mygallery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.sermage.mygallery.navigation.NavigationHost
import com.sermage.mygallery.ui.theme.MyGalleryTheme
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

//    override fun onNewIntent(intent: Intent?) {
//        super.onNewIntent(intent)
//        intent?.handleIntent()
//    }
//
//    private fun Intent.handleIntent() {
//        when (action) {
//            Intent.ACTION_VIEW -> handleIntent(data)
//            else -> Unit
//        }
//    }
//
//    private fun handleIntent(data: Uri?) {
//
//    }
}


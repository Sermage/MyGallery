package com.example.mygallery

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mygallery.ui.elements.GridItemCard
import com.example.mygallery.ui.elements.StaggeredVerticalGrid
import com.example.mygallery.ui.theme.MyGalleryTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyGalleryTheme {
                // A surface container using the 'background' color from the theme
                EditorialPictures()
            }
        }

    }

    @Composable
    fun EditorialPictures() {
        val vm = hiltViewModel<MainViewModel>()
        val images = vm.imagesState.collectAsState().value
        Log.d("IMAGES", images.toString())
        StaggeredVerticalGrid(
            modifier = Modifier.padding(horizontal = 20.dp)
        ) {
            images.forEach {
                GridItemCard(it)
            }
        }
    }
}


package com.example.mygallery.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mygallery.MainViewModel
import com.example.mygallery.ui.elements.GridItemCard
import com.example.mygallery.ui.elements.StaggeredVerticalGrid

@Composable
fun Images() {
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
package com.example.mygallery.ui.elements

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.mygallery.domain.images.Image

@Composable
fun ImagesListGrid(
    items: List<Image>,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {
        item {
            StaggeredVerticalGrid {
                items.forEach {
                    GridItemCard(it)
                }
            }
        }
    }
}
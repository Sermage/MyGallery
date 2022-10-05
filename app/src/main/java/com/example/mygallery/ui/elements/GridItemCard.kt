package com.example.mygallery.ui.elements

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import coil.compose.rememberImagePainter
import com.example.mygallery.domain.images.Image
import com.example.mygallery.ui.theme.Silver


@Composable
fun GridItemCard(
    photo: Image,
    modifier: Modifier = Modifier
) {
    var size by remember { mutableStateOf(Size.Zero) }
    Surface(
        modifier = modifier
            .padding(4.dp)
            .clickable(
                onClick = { },
            )
            .onGloballyPositioned { coordinates ->
                size = coordinates.size.toSize()
            },
        color = Silver,
        elevation = 0.dp,
        shape = RectangleShape
    ) {
        val dpHeight = photo.toCardHeightDp(size.width)
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(dpHeight),
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = rememberImagePainter(photo.imageUrl.small),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
            )
        }
    }
}

@Composable
private fun Image.toCardHeightDp(viewWidth: Float): Dp {
    val pxHeight = viewWidth * height / width
    return LocalDensity.current.run { pxHeight.toDp() }
}
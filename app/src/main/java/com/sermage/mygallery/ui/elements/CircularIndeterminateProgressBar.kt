package com.sermage.mygallery.ui.elements

import androidx.compose.foundation.layout.Box
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sermage.mygallery.ui.theme.MyGalleryTheme


@Composable
fun CircularIndeterminateProgressBar(
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        CircularProgressIndicator(
            color = MaterialTheme.colors.primary,
            strokeWidth = 4.dp,
        )
    }
}

@Preview
@Composable
fun CircularIndeterminateProgressBarPreview() {
    MyGalleryTheme {
        CircularIndeterminateProgressBar()
    }
}
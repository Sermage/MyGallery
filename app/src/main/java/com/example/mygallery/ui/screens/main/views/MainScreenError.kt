package com.example.mygallery.ui.screens.main.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Warning
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mygallery.R
import com.example.mygallery.ui.theme.MyGalleryTheme

@Composable
fun MainScreenError(
    modifier: Modifier = Modifier,
    onReloadClick: () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                modifier = Modifier.size(96.dp),
                imageVector = Icons.Rounded.Warning,
                tint = MaterialTheme.colors.onSurface,
                contentDescription = "Error loading items"
            )

            Text(
                modifier = Modifier.padding(top = 16.dp, bottom = 24.dp),
                text = stringResource(id = R.string.loading_error_text),
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.onSurface,
                textAlign = TextAlign.Center
            )

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = MaterialTheme.colors.primary,
                        shape = MaterialTheme.shapes.small
                    ),
                onClick = onReloadClick
            ) {
                Text(
                    text = stringResource(id = R.string.refresh_button_title),
                    style = MaterialTheme.typography.body1,
                    color = MaterialTheme.colors.background
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun MainScreenErrorPreview() {
    MyGalleryTheme {
        MainScreenError(
            onReloadClick = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun MainScreenErrorPreviewDark() {
    MyGalleryTheme(darkTheme = true) {
        MainScreenError(
            onReloadClick = {}
        )
    }
}
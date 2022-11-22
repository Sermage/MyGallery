package com.sermage.mygallery.ui.elements

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sermage.mygallery.R
import com.sermage.mygallery.ui.theme.MyGalleryTheme

@Composable
fun SearchButton(
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(40.dp)
            .padding(horizontal = 24.dp),
        shape = MaterialTheme.shapes.small,
        colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.surface),
    ) {
        Icon(
            imageVector = Icons.Default.Search,
            contentDescription = null,
            tint = MaterialTheme.colors.onSurface.copy(alpha = 0.8f)

        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = stringResource(R.string.search_hint),
            color = MaterialTheme.colors.onSurface.copy(alpha = 0.32f),
            modifier = Modifier.weight(1f)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SearchButtonPreview() {
    MyGalleryTheme {
        SearchButton {}
    }
}

@Preview(showBackground = true)
@Composable
fun SearchButtonPreviewDark() {
    MyGalleryTheme(darkTheme = true) {
        SearchButton {}
    }
}
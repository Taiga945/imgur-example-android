package com.example.imgur.galleryitem
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.Composable
import coil.compose.AsyncImage

@Composable
fun GalleryItemScreen(
    viewModel: GalleryViewModel = viewModel()
) {
    Column {
        Text(text = viewModel.describe)
        AsyncImage(
            model = viewModel.url,
            contentDescription = null,
        )
    }
}
package com.example.imgur.galleryitem

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.gallery.GalleryResponse
import com.example.data.gallery.GetGalleryUseCase
import com.example.data.image.GetImageCommentsUseCase
import com.example.data.image.ImageCommentsResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GalleryViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    val id: String = checkNotNull(savedStateHandle["imageId"])
    val url: String = checkNotNull(savedStateHandle["url"])
    val describe: String = checkNotNull(savedStateHandle["describe"])

    val state: MutableStateFlow<ImageCommentsResponse?> = MutableStateFlow<ImageCommentsResponse?>(null)
    fun initData() {
        viewModelScope.launch {
            state.value = GetImageCommentsUseCase().getImages(id)
        }
    }
}
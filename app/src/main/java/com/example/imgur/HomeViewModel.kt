package com.example.imgur

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.gallery.GalleryResponse
import com.example.data.gallery.GetGalleryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel

class HomeViewModel @Inject constructor() : ViewModel() {
    val state: MutableStateFlow<GalleryResponse?> = MutableStateFlow<GalleryResponse?>(null)
    fun initData() {
        viewModelScope.launch {
            state.value = GetGalleryUseCase().getImages()
        }
    }
}
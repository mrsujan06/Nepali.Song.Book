package com.songs.nepalisongbook.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.songs.nepalisongbook.HomeViewState
import com.songs.nepalisongbook.repository.DataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: DataRepository) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeViewState())
    val uiState: StateFlow<HomeViewState> = _uiState

    init {
        fetchArtists()
        fetchTopLyrics()
    }

    private fun fetchArtists() {
        viewModelScope.launch {
            val artists = repository.getArtists()
            _uiState.value = _uiState.value.copy(artists = artists)

        }
    }

    private fun fetchTopLyrics() {
        viewModelScope.launch {
            val topLyrics = repository.getTopLyrics()
            _uiState.value = _uiState.value.copy(topLyrics = topLyrics)
        }
    }

}

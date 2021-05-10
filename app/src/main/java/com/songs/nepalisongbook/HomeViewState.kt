package com.songs.nepalisongbook

import com.songbook.nepalisongbook.model.Track
import com.songs.nepalisongbook.model.Artist


/**
 * Represents the view state for the home screen.
 * */
data class HomeViewState(
    val artists: List<Artist> = emptyList(),
    val topLyrics: List<Track> = emptyList()
) {
    val showLoading: Boolean
        get() = artists.isEmpty() || topLyrics.isEmpty()
}

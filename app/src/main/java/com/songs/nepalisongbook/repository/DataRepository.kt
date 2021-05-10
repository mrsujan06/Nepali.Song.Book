package com.songs.nepalisongbook.repository

import com.songbook.nepalisongbook.model.Track
import com.songs.nepalisongbook.model.Artist
import com.songs.nepalisongbook.model.TopTracks

interface DataRepository {
    suspend fun getArtists(): List<Artist>
    suspend fun getTopLyrics():List<Track>
}
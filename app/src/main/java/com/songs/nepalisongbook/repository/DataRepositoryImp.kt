package com.songs.nepalisongbook.repository

import com.google.firebase.firestore.FirebaseFirestore
import com.songbook.nepalisongbook.model.Track
import com.songs.nepalisongbook.model.Artist
import com.songs.nepalisongbook.model.TopTracks
import com.songs.nepalisongbook.util.Constant.Companion.ALBUMS
import com.songs.nepalisongbook.util.Constant.Companion.ARTISTS
import com.songs.nepalisongbook.util.Constant.Companion.TRACKS
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class DataRepositoryImp @Inject constructor(db: FirebaseFirestore) : DataRepository {

    private val mArtistCollection = db.collection(ARTISTS)
    private val mAlbumCollection = db.collectionGroup(ALBUMS)
    private val mTopLyricsByTopRating = db.collectionGroup(TRACKS).whereEqualTo("rating", "5")

    override suspend fun getArtists(): List<Artist> {
        val snapshot = mArtistCollection.get().await()
        return snapshot.toObjects(Artist::class.java)
    }

    override suspend fun getTopLyrics(): List<Track> {
        val snapshot = mTopLyricsByTopRating.get().await()
        return snapshot.toObjects(Track::class.java)
    }
}

//    document("The Uglyz").collection("album")
//    private val trackCollectionReference =
//        albumCollectionReference.document("Rush").collection("tracks")


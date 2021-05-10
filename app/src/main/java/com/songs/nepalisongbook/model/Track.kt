package com.songbook.nepalisongbook.model

data class Track(
    var album: String,
    var artist: String,
    var image: String,
    var length: String,
    var likes: Any,
    var lyrics: String,
    var name: String,
    var number: String,
    var rating: String,
    var views: Int,
    var youtube: String,
) {
    constructor() : this(
        "",
        "", "", "", 0, "",
        "", "", "", 0, ""
    )

}
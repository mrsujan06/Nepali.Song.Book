package com.songs.nepalisongbook.model

data class Album(
    var artist: String,
    var image: String,
    var name: String,
    var release: String,
) {
    constructor() : this(
        "",
        "", "", ""
    )
}
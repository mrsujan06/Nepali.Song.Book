package com.songs.nepalisongbook.model

data class Artist(
    var bio: String,
    var genre: String,
    var name: String,
    var image: String,
    var instagram: String,
    var members: String,
    var spotify: String,
    var year: String,
    var youtube: String,
    ) {

    constructor() : this("",
        "", "", "",
        "", "", "", "", ""
    )
}
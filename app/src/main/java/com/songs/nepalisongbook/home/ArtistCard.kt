package com.songs.nepalisongbook.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.songs.nepalisongbook.model.Artist
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun ArtistCard(artist: Artist) {

    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = 2.dp,
        modifier = Modifier
            .size(136.dp)
            .padding(2.dp)
    ) {
        Column(
            Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.surface)
        ) {

            CoilImage(
                data = artist.image,
                contentDescription = artist.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(136.dp)
                    .height(96.dp)
            )

            Text(
                text = artist.name,
                modifier = Modifier
                    .paddingFromBaseline(top = 24.dp)
                    .padding(horizontal = 8.dp)
            )
        }
    }
}

@Preview
@Composable
fun PreviewPlantThemeCard() {
    ArtistCard(artist = Artist())
}


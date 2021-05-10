package com.songs.nepalisongbook.home

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.QueueMusic
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.songbook.nepalisongbook.model.Track
import com.songs.nepalisongbook.model.TopTracks
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun TopLyricsCard(lyrics: Track) {

    Row(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        HomeGardenPlantImage(lyrics)

        Column {

            TitleDescriptionCheckboxRow(lyrics)

            Divider()
        }

    }

}

@Composable
private fun HomeGardenPlantImage(lyrics: Track) {
    CoilImage(
        data = lyrics.image,
        contentDescription = lyrics.name.plus("Image"),
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(64.dp)
            .clip(MaterialTheme.shapes.small)
    )
}

@Composable
private fun TitleDescriptionCheckboxRow(lyrics: Track) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        TitleAndDescription(lyrics)

        LyricsDetailIcon()
    }
}

@Composable
private fun RowScope.TitleAndDescription(lyrics: Track) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.weight(1F)
    ) {
        Text(
            text = lyrics.name,
            style = MaterialTheme.typography.h2,
            modifier = Modifier.paddingFromBaseline(top = 24.dp)
        )
        Text(
            "This is a description",
            style = MaterialTheme.typography.body1,
            modifier = Modifier.paddingFromBaseline(bottom = 24.dp)
        )
    }
}

@Composable
private fun LyricsDetailIcon() {
    Icon(
        Icons.Filled.QueueMusic,
        contentDescription = null,
    )
}


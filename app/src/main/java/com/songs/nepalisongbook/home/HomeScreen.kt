package com.songs.nepalisongbook.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.songbook.nepalisongbook.model.Track
import com.songs.nepalisongbook.HomeViewState
import com.songs.nepalisongbook.R
import com.songs.nepalisongbook.model.Artist
import com.songs.nepalisongbook.model.TopTracks
import com.songs.nepalisongbook.ui.theme.NepaliSongBookTheme
import com.songs.nepalisongbook.viewmodel.HomeViewModel

@Composable
fun HomeScreen(
    viewModel: HomeViewModel
) {
    val currentState: State<HomeViewState> = viewModel.uiState.collectAsState()
    HomeScreenScaffold(currentState.value)
}

@Composable
private fun HomeScreenLoader(paddingValues: PaddingValues) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {
        CircularProgressIndicator(
            modifier = Modifier
                .wrapContentSize()
                .align(Alignment.Center)
        )
    }
}


@Composable
fun HomeScreenScaffold(state: HomeViewState) {
    Scaffold(
        content = { paddingValues ->
            if (state.showLoading) {
                HomeScreenLoader(paddingValues)
            } else {
                HomeScreenContent(paddingValues = paddingValues, state = state)
            }
        },
        bottomBar = { BloomHomeBottomAppBar() }
    )
}

@Composable
fun HomeScreenContent(paddingValues: PaddingValues, state: HomeViewState) {

    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier.fillMaxSize()
    ) {
        var searchQuery: String by remember { mutableStateOf("") }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 16.dp)
        ) {

            Spacer(modifier = Modifier.padding(30.dp))

            SearchBarInput(search = searchQuery, onSearchQueryChange = { searchQuery = it })

            BrowseArtistSection(state.artists)

            Spacer(modifier = Modifier.padding(8.dp))

            GenreSection()

            TrendingLyricsSection(state.topLyrics)
        }
    }
}


@Composable
private fun SearchBarInput(search: String, onSearchQueryChange: (String) -> Unit) {
    OutlinedTextField(
        value = search,
        onValueChange = onSearchQueryChange,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = MaterialTheme.colors.onPrimary,
            focusedBorderColor = MaterialTheme.colors.onPrimary,
            cursorColor = MaterialTheme.colors.onPrimary
        ),
        leadingIcon = { Icon(Icons.Filled.Search, contentDescription = null) },
        label = {
            Text(
                text = stringResource(R.string.search_label),
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.onPrimary
            )
        },

        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text),
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp)
    )
}

@Composable
private fun BrowseArtistSection(artist: List<Artist>) {

    Text(
        text = stringResource(R.string.artist_label),
        style = MaterialTheme.typography.h1,
        color = MaterialTheme.colors.onPrimary,
        modifier = Modifier
            .paddingFromBaseline(32.dp)
    )

    Spacer(Modifier.height(16.dp))

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(artist) {
            ArtistCard(artist = it)
        }
    }

}

@Composable
fun GenreSection() {

    Text(
        stringResource(R.string.genre_label),
        style = MaterialTheme.typography.h1,
        color = MaterialTheme.colors.onPrimary,
        modifier = Modifier
            .paddingFromBaseline(32.dp)
    )

    Spacer(modifier = Modifier.padding(8.dp))

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {

        Row(modifier = Modifier.fillMaxWidth()) {
            Button(modifier = Modifier
                .width(190.dp)
                .padding(end = 8.dp, bottom = 8.dp), onClick = { /*TODO*/ }) {
                Text(
                    text = stringResource(id = R.string.pop),
                    style = MaterialTheme.typography.body1
                )
            }

            Button(modifier = Modifier
                .width(190.dp)
                .padding(bottom = 8.dp), onClick = { /*TODO*/ }) {
                Text(
                    text = stringResource(id = R.string.rock),
                    style = MaterialTheme.typography.body1
                )
            }
        }

        Row {
            Button(modifier = Modifier
                .width(190.dp)
                .padding(end = 8.dp, bottom = 8.dp), onClick = { /*TODO*/ }) {
                Text(
                    text = stringResource(id = R.string.metal),
                    style = MaterialTheme.typography.body1
                )

            }

            Button(
                modifier = Modifier.width(190.dp),
                onClick = { /*TODO*/ }) {
                Text(
                    text = stringResource(id = R.string.hiphop),
                    style = MaterialTheme.typography.body1
                )
            }
        }

    }
}

@Composable
fun TrendingLyricsSection(lyrics: List<Track>) {

    Row(
        modifier = Modifier
            .paddingFromBaseline(40.dp)
            .fillMaxWidth()
    ) {
        Text(
            stringResource(R.string.popular_lyrics_label),
            style = MaterialTheme.typography.h1,
            modifier = Modifier
                .weight(1f)
        )

    }

    Spacer(modifier = Modifier.padding(8.dp))

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .fillMaxSize()
            .padding(2.dp)
    ) {
        items(lyrics) {
            TopLyricsCard(lyrics = it)
        }
    }

}

@Composable
fun BloomHomeBottomAppBar() {

    BottomAppBar(backgroundColor = MaterialTheme.colors.primary) {
        SongBookBottomButton(
            selected = true,
            icon = Icons.Default.Home,
            labelText = "Home"
        )
        SongBookBottomButton(
            selected = false,
            icon = Icons.Default.FavoriteBorder,
            labelText = "Favorites"
        )
        SongBookBottomButton(
            selected = false,
            icon = Icons.Default.AccountCircle,
            labelText = "Profile"
        )
        SongBookBottomButton(
            selected = false,
            icon = Icons.Default.ShoppingCart,
            labelText = "Cart"
        )
    }

}

@Composable
fun RowScope.SongBookBottomButton(selected: Boolean, icon: ImageVector, labelText: String) {

    BottomNavigationItem(
        selected = selected,
        onClick = {/*TODO*/ },
        icon = { Icon(icon, contentDescription = null) },
        label = { Text(labelText) })
}

@Preview
@Composable
fun PreviewHomeScreenDark() {
    NepaliSongBookTheme(darkTheme = true) {
        HomeScreen(viewModel())
    }
}

@Preview
@Composable
fun PreviewHomeScreenLight() {
    NepaliSongBookTheme(darkTheme = false) {
        HomeScreen(viewModel())
    }
}


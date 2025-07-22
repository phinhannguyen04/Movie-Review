package com.example.moviereview.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.moviereview.data.movieData


@Composable
fun SearchScreen(controller: NavHostController) {
    var movieName by rememberSaveable { mutableStateOf("")}

    Scaffold(
        Modifier
            .safeDrawingPadding()
            .fillMaxSize(),
        topBar = { SearchBar(
            movieName = movieName,
            onChangeMovieName = {
                movieName = it
            }
        ) },
        bottomBar = { BottomBar(navController = controller) }
    ) {
        if (movieName.isNotEmpty()) {
            LazyColumn(
                Modifier
                    .padding(it)
                    .padding(16.dp)
            ) {
                items (movieData.filter { it.title.contains(movieName, ignoreCase = true)} ) {
                    MovieItemDetail(
                        it.title, it.imageRes, it.rating, it.year,
                        onClick = { controller.navigate("${Destination.DETAIL.name}/${it.id}") }
                    )
                }
            }
        }
        else {
            Box (
                modifier = Modifier
                    .padding(it)
                    .fillMaxSize()
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Search Your Movie",
                )
            }
        }
    }
}

@Composable
fun SearchBar(
    movieName: String,
    onChangeMovieName: (String) -> Unit
){
    OutlinedTextField(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        value = movieName,
        onValueChange = {
            onChangeMovieName(it)
        },
        placeholder = { Text("Search") },
        shape = MaterialTheme.shapes.small,
        leadingIcon = {
            Icon(Icons.Filled.Search, contentDescription = null)
        },
        keyboardOptions = KeyboardOptions (
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Search
        )
    )
}
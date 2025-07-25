package com.example.moviereview.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.moviereview.viewModel.MainViewModel

@Composable
fun ReviewScreen(
    id: Int,
    controller: NavHostController,
    viewModel: MainViewModel
) {
    val movieState by viewModel.movieState.collectAsState()
    val movieFound = movieState.find { it.id == id }

    val currentReviewRating by viewModel.movieRating.collectAsState()
    val currentReviewComment by viewModel.movieReview.collectAsState()

    Scaffold (
        Modifier
            .safeDrawingPadding()
            .fillMaxSize(),
        topBar = { BackButton(
            modifier = Modifier.padding(start = 15.dp, top = 30.dp),
            color = Color.Black,
            onClick = {controller.popBackStack()}
        ) },
        floatingActionButton = {
            DoneButton(
                onClick = {
                    viewModel.updateMovie(movieFound!!.id)
                    controller.popBackStack()
                }
            )
        }
    ) {
        if (movieFound != null) {
            LazyColumn (
                Modifier
                    .padding(it)
                    .padding(16.dp)
            ){
                item {
                    MovieItem(title = movieFound.title, imageRes = movieFound.imageRes, rating = currentReviewRating.toString(), year = movieFound.year)
                }

                item {
                    Text(
                        "Đánh giá phim",
                        modifier = Modifier.padding(vertical = 16.dp),
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Light
                    )
                }

                item {
                    StarRating(
                        currentRating = currentReviewRating,
                        onRatingChanged = { it -> viewModel.updateMovieRating(it) }
                    )
                }


                item {
                    OutlinedTextField(
                        value = currentReviewComment,
                        onValueChange = { it ->
                            viewModel.updateMovieComment( it)
                        },
                        modifier = Modifier
                            .fillMaxWidth(),
                        placeholder = {
                            Text("Nhập ghi chú", fontSize = 28.sp)
                        },
                        minLines = 9,
                        textStyle = TextStyle(fontSize = 28.sp)
                    )
                }
            }
        }
    }
}


@Composable
fun StarRating(
    currentRating: Int,
    onRatingChanged: (Int) -> Unit
) {
    Row (
        Modifier
            .padding(vertical = 16.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        for (i in 1..5) {
            Icon(
                imageVector = Icons.Filled.Star,
                contentDescription = null,
                modifier = Modifier
                    .size(64.dp)
                    .padding(horizontal = 5.dp)
                    .clickable {
                        onRatingChanged(i)
                    },
                tint = if(i <= currentRating) Color(0xFFFFD700) else Color(0xFFA2ADB1),
            )
        }
    }
}


@Composable
fun MovieItem(
    title: String,
    imageRes: Int,
    rating: String,
    year: String
) {
    Row(
        modifier = Modifier
            .safeDrawingPadding()
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Row (
            Modifier.size(64.dp)
        ) {
            Image(
                painter = painterResource(imageRes),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }

        Column (
            Modifier
                .padding(start = 16.dp)
                .fillMaxWidth()
                .wrapContentHeight(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Text(
                title,
                modifier = Modifier
                    .padding(bottom = 16.dp),
                fontWeight = FontWeight.SemiBold,
                fontSize = 24.sp
            )

            Row (
                Modifier
                    .fillMaxWidth(),
            ) {
                Row (
                    Modifier
                        .weight(0.5f),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        Icons.Default.Star,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.secondary,
                        modifier = Modifier.size(32.dp)
                    )
                    Text(rating, fontSize = 22.sp, modifier = Modifier.padding(start = 4.dp))
                }
                Row (
                    Modifier
                        .weight(0.5f),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        Icons.Default.DateRange,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(32.dp)
                    )
                    Text(year, fontSize = 22.sp, modifier = Modifier.padding(start = 4.dp))
                }
            }
        }
    }
}


@Composable
fun DoneButton(onClick: () -> Unit) {
    Button(onClick = onClick) {
        Icon(
            Icons.Filled.Done,
            contentDescription = null,
            modifier = Modifier.size(ButtonDefaults.IconSize)
        )
    }
}
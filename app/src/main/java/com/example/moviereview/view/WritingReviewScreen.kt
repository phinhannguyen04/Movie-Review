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
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Star
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.moviereview.data.movieData
import com.example.moviereview.viewModel.MainViewModel


@Composable
fun WritingReviewScreen(controller: NavHostController) {
    Scaffold (
        Modifier,
    ) {
        Column(
            Modifier
                .fillMaxSize()
                .padding(it),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            /*
            * Code test chuyển hướng trang
            * */
            Row (
                Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                horizontalArrangement = Arrangement.SpaceAround,
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = null,
                    modifier = Modifier
                        .clickable(
                            onClick = { controller.navigate("watchList") }
                        )
                )
                Icon(
                    imageVector = Icons.Filled.ArrowForward,
                    contentDescription = null,
                    modifier = Modifier
                        .clickable(
                            onClick = { controller.navigate("detail") }
                        )
                )
            }
            Text(text = "Writing Reviews Screen")
        }
    }
}

@Preview
@Composable
fun ReviewScreen(viewModel: MainViewModel = viewModel()) {

//    val movieRating by viewModel.movieRating.collectAsState()
    val movieReview by viewModel.movieReview.collectAsState()
    val movieState by viewModel.movieState.collectAsState()

    val movie = movieData.get(0)
    /*
    * Tim phim voi id tuong ung
    * Lay rating hien tai cua phim vua tim duoc
    * */
    val phim = movieState.find { it.id == movie.id }
    val currentRating = phim?.rating?.toIntOrNull() ?: 0

    Scaffold (
        Modifier
            .fillMaxSize(),
        topBar = {

        }
    ) {
        LazyColumn (
            Modifier
                .padding(it)
                .padding(16.dp)
        ){
            item {
                MovieItem(title = movie.title, imageRes = movie.imageRes, rating = currentRating.toString(), year = movie.year)
            }

            item {
                Text(
                    "Đánh giá phim",
                    modifier = Modifier.padding(vertical = 16.dp),
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Light
                )
            }

            if (phim != null) {
                item {
                    StarRating(
                        currentRating = currentRating,
                        onRatingChanged = { it -> viewModel.updateMovieRating(movie.id, it) }
                    )
                }
            }

            item {
                OutlinedTextField(
                    value = movieReview,
                    onValueChange = { it ->
                        viewModel.updateMovieComment(it)
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
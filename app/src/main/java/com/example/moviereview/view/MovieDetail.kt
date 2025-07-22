package com.example.moviereview.view

import com.example.moviereview.R

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.AppTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Person
import androidx.navigation.NavHostController
import com.example.moviereview.data.movieData
import com.example.moviereview.model.MovieDetails


@Composable
fun MovieHeader(image: Int, controller: NavHostController){
    val image = painterResource(image)
    Box {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp))
                .height(300.dp)
        )
        {
            Image(
                painter = image,
                contentDescription = "Movie Poster",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
            )
        }
        Box(modifier = Modifier
            .fillMaxSize()

        ){
            BackButton(
                modifier = Modifier
//                    .align(Alignment.Center)
                    .padding(start = 15.dp, top = 30.dp),
                onClick = {
                    controller.popBackStack()
                }
            )
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center)


        ){
            PlayButton(
                modifier = Modifier
                    .align(Alignment.Center),
                onClick = {}
            )
        }
    }
}

@Composable
fun PlayButton(
    modifier: Modifier = Modifier,
    onClick: () ->Unit ={}
){
    IconButton(
        onClick = onClick,
        modifier = modifier
            .size(80.dp)
            .clip(RoundedCornerShape(40.dp))
            .background(Color.Black.copy(alpha = 0.5f))
    ){
        Icon(
            imageVector = Icons.Filled.PlayArrow,
            contentDescription = "Play Video!",
            tint = Color.White,
            modifier = Modifier
                .size(40.dp)
        )
    }
}

@Composable
fun BackButton(
    modifier: Modifier = Modifier,
    onClick: () ->Unit = {}
){
    IconButton(
        onClick = onClick,
        modifier = modifier
            .size(30.dp)
            .fillMaxSize()
    ){
        Icon(
            imageVector = Icons.Filled.ArrowBack,
            contentDescription = "Back",
            tint = Color.White
        )
    }
}

@Composable
fun Chip(text: String) {
    Text(
        text = text,
        color = Color.White,
        modifier = Modifier
            .padding(top = 10.dp, end = 25.dp, bottom = 10.dp)
            .background(color = MaterialTheme.colorScheme.primary, RoundedCornerShape(10.dp))
            .border(1.dp, color = MaterialTheme.colorScheme.primary, RoundedCornerShape(10.dp))
            .padding(horizontal = 25.dp, vertical = 3.dp)
    )
}

@Composable
fun StarRating (rating: Int){
    Row{
        repeat(rating){
            Icon(
                imageVector = Icons.Filled.Star,
                contentDescription = "star",
                tint = Color.Yellow,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

@Composable
fun MovieInfoSection(data: MovieDetails){
    var isFavorite by remember { mutableStateOf(false) }
    val image1 = painterResource(R.drawable.avatar1)
    val image2 = painterResource(R.drawable.avatar2)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(30.dp, 30.dp, 0.dp, 0.dp))
            .background(MaterialTheme.colorScheme.surface)
            .padding(20.dp)

    ){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = data.title,
                style = MaterialTheme.typography.headlineLarge,
                color = MaterialTheme.colorScheme.onSurface,
                fontWeight = FontWeight(900)
            )
            Spacer(modifier = Modifier
                .weight(1f)
            )
            val scale by animateFloatAsState(
                targetValue = if (isFavorite) 1.3f else 1f,
                animationSpec = tween(durationMillis = 200),
                label = "scaleAnimation"
            )
            val color by animateColorAsState(
                targetValue = if (isFavorite) Color.Red else MaterialTheme.colorScheme.onSurface,
                animationSpec = tween(durationMillis = 200),
                label = "colorAnimation"
            )
            IconButton(
                onClick = {isFavorite = !isFavorite},
                modifier = Modifier
                    .size(55.dp)
                    .padding(10.dp)
                    .graphicsLayer{
                        scaleX = scale
                        scaleY = scale
                    }
            ){
                Icon(
                    imageVector = if (isFavorite) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder,
                    contentDescription = "Favorite",
                    tint = color
                )
            }
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth())
        {
            Icon(
                imageVector = Icons.Filled.Star,
                contentDescription = "Rating",
                tint = Color.Yellow)
            Text(
                text= "${data.rating}/5.0",
                color = MaterialTheme.colorScheme.onSurface,
                fontSize = 24.sp
            )
            Spacer(modifier = Modifier
                .weight(2f))

            Icon(
                imageVector = Icons.Filled.Person,
                contentDescription = "Positive",
                tint = MaterialTheme.colorScheme.onSurface)
            Text(
                text="65%",
                color = MaterialTheme.colorScheme.onSurface,
                fontSize = 24.sp
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically
        ){
            data.genres.forEach {
                Chip(it)
            }
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 15.dp)
        )
        {
            Column(modifier = Modifier
                .padding(end = 35.dp)){
                Text(
                    text = "Year",
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    fontSize = 20.sp
                )
                Text(
                    text = data.year,
                    color = MaterialTheme.colorScheme.onSurface,
                    fontSize = 20.sp
                )
            }
            Column(modifier = Modifier
                .padding(end = 35.dp)) {
                Text(
                    text ="Language",
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    fontSize = 20.sp
                )
                Text(
                    text ="English",
                    color = MaterialTheme.colorScheme.onSurface,
                    fontSize = 20.sp
                )
            }
            Column(modifier = Modifier
                .padding(end = 35.dp)) {
                Text(
                    text ="Rating",
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    fontSize = 20.sp
                )
                Text(
                    text = data.rating,
                    color = MaterialTheme.colorScheme.onSurface,
                    fontSize = 20.sp
                )
            }
        }
        Row(){
            Text(
                text="Description",
                style = MaterialTheme.typography.headlineLarge,
                color = MaterialTheme.colorScheme.onSurface,
                fontWeight = FontWeight(900)
            )
        }
        Row( modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
        ){
            Text(
                text = data.description,
                color = MaterialTheme.colorScheme.onSurface,
                lineHeight = 29.sp,
                fontSize = 20.sp,
                fontWeight = FontWeight.Thin
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(
                text= "Cast",
                style = MaterialTheme.typography.headlineLarge,
                color = MaterialTheme.colorScheme.onSurface,
                fontWeight = FontWeight.Bold
            )
            Button(
                onClick = {},
                shape = RoundedCornerShape(15.dp),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondaryContainer)){
                Text("See More", color = MaterialTheme.colorScheme.onSecondaryContainer)
            }
        }
        Spacer(modifier = Modifier.height(12.dp))

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = PaddingValues(end = 16.dp)
        ) {
            items(10) { index ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Image(
                        painter = image1,
                        contentDescription = "Cast image",
                        modifier = Modifier
                            .size(100.dp)
                            .clip(RoundedCornerShape(16.dp)),
                        contentScale = ContentScale.Crop
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = "Cast Name $index",
                        color = MaterialTheme.colorScheme.onSurface,
                        fontSize = 18.sp
                    )
                }
            }
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(
                text = "Reviews",
                style = MaterialTheme.typography.headlineLarge,
                color = MaterialTheme.colorScheme.onSurface,
                fontWeight = FontWeight.Bold
            )
            Button(
                onClick = {},
                shape = RoundedCornerShape(15.dp),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondaryContainer)){
                Text("See More", color = MaterialTheme.colorScheme.onSecondaryContainer)
            }
        }
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
        ){
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = image2,
                    contentDescription = "comment1",
                    modifier = Modifier
                        .padding(end = 10.dp)
                        .height(40.dp)
                        .width(40.dp)
                        .clip(RoundedCornerShape(20.dp)),
                    contentScale = ContentScale.Crop,
                )
                Text(
                    text = "Thanh Da" ,
                    color = MaterialTheme.colorScheme.onSurface,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.weight(1f))
                StarRating(rating = 4)
            }
            Row(modifier = Modifier.padding(start = 50.dp)) {
                Text(
                    text = "The movie is really worth watching, but the picture quality is not good.",
                    color = MaterialTheme.colorScheme.onSurface,
                    style = MaterialTheme.typography.bodyMedium,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Thin
                )
            }
        }
    }
}


@Composable
fun MovieDetailScreen(id: Int, controller: NavHostController) {

    val movieFound = movieData.find { it.id == id }

    if (movieFound == null) {
        return
    }

    Scaffold (
        modifier = Modifier,
        bottomBar = { BottomBar(navController = controller) },
        floatingActionButton = { AddReviewButton(onClick = {}) }
    ) {
        Column(
            Modifier.padding(it)
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            MovieHeader(movieFound.imageRes, controller)
            MovieInfoSection(movieFound)
        }
    }
}


@Composable
fun AddReviewButton(onClick:() -> Unit) {
    Button (onClick = onClick){
        Icon(
            Icons.Filled.Create,
            contentDescription = null,
            modifier = Modifier
                .size(ButtonDefaults.IconSize)
                .clip(CircleShape)
        )
    }
}

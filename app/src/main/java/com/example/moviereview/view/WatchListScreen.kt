package com.example.moviereview.view

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.moviereview.R
import com.example.moviereview.data.MovieDataSource.movieData
import com.example.moviereview.viewModel.MainViewModel

@Composable
fun WatchListScreen(
    controller: NavHostController,
    viewModel: MainViewModel
) {
    val movieData by viewModel.movieState.collectAsState()

    Scaffold (
        Modifier
            .padding(),
        bottomBar = {
            BottomBar(navController = controller)
        }
    ) {
        Column(
            Modifier
                .fillMaxSize()
                .padding(it),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LazyColumn {
                item {
                    Text (
                        text = "WATCHLIST",
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth(),
                    )
                }
                items (movieData) {
                    MovieItemDetail(
                        it.title,
                        it.imageRes,
                        it.rating,
                        it.year,
                        onClick = { controller.navigate("${Destination.DETAIL.name}/${it.id}") }
                    )
                }
            }
        }
    }
}

@Composable
fun MovieItemDetail(
    title: String,
    imageRes: Int,
    rating: String,
    year: String,
    onClick: () -> Unit = {}
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 8.dp)
            .clickable(
                onClick = onClick
            ),
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
                        .weight(0.5f)
                ) {
                    Icon(
                        Icons.Default.Star,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.secondary,
                        modifier = Modifier.size(20.dp)
                    )
                    Text(rating, fontSize = 20.sp, modifier = Modifier.padding(start = 4.dp))
                }
                Row (
                    Modifier
                        .weight(0.5f)
                ) {
                    Icon(
                        Icons.Default.DateRange,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(20.dp)
                    )
                    Text(year, fontSize = 20.sp, modifier = Modifier.padding(start = 4.dp))
                }
            }
        }
    }
}

enum class Destination (
    @DrawableRes val icon: Int,
    val contentDescription: String,
    val isBottomBarItem: Boolean = true
) {
    HOME(
        icon = R.drawable.ic_movie,
        contentDescription = "Home"
    ),
    SEARCH(
        icon = R.drawable.ic_search,
        contentDescription = "Search"
    ),
    PROFILE(
        icon = R.drawable.ic_profilee,
        contentDescription = "Profile"
    ),
    DETAIL(
        icon = 0,
        contentDescription = "Detail",
        isBottomBarItem = false
    ),
    REVIEW(
        icon = 0,
        contentDescription = "Review",
        isBottomBarItem = false
    )
}

@Composable
fun BottomBar(navController: NavHostController) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar (windowInsets = NavigationBarDefaults.windowInsets) {
        Destination.entries.filter { it.isBottomBarItem }.forEachIndexed { index, destination ->
            val selected = currentDestination?.route == destination.name
            NavigationBarItem (
                selected = selected,
                onClick = {
                    navController.navigate(destination.name) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Icon(
                        painter = painterResource(destination.icon),
                        contentDescription = destination.contentDescription,
                        modifier = Modifier
                            .size(24.dp)
                    )
                },
                label = { Text(destination.contentDescription) }
            )
        }
    }
}


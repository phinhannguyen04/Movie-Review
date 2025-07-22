package com.example.moviereview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.compose.AppTheme
import com.example.compose.primaryLight
import com.example.moviereview.view.Destination
import com.example.moviereview.view.DetailScreen
import com.example.moviereview.view.MovieDetailScreen
import com.example.moviereview.view.ProfileScreen
import com.example.moviereview.view.ReviewScreen
import com.example.moviereview.view.SearchScreen
import com.example.moviereview.view.WatchListScreen
import com.example.moviereview.view.WritingReviewScreen
import com.example.ui.theme.bodyFontFamily
import com.example.ui.theme.displayFontFamily


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Destination.HOME.name,
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        /* /HOME */
                        composable(Destination.HOME.name) { WatchListScreen(controller = navController) }
                        /* /SEARCH */
                        composable(Destination.SEARCH.name) { SearchScreen(controller = navController) }
                        /* /PROFILE */
                        composable(Destination.PROFILE.name) { ProfileScreen(controller = navController) }
                        /* /DETAIL/<id> */
                        composable (
                            "${Destination.DETAIL.name}/{id}",
                            arguments = listOf(navArgument("id") { type = NavType.IntType })
                        ) {
                            val id = it.arguments?.getInt("id") ?: 0
                            if (id != 0) {
                                 MovieDetailScreen(id, controller = navController)
                            }
                            else {
                                Text("Error: Movie ID not found!")
                            }
                        }
                    }
                }
            }
        }
    }
}


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
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.compose.AppTheme
import com.example.compose.primaryLight
import com.example.moviereview.view.DetailScreen
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
                    val controller = rememberNavController()
                    NavHost(navController = controller, startDestination = "watchList", Modifier.padding(innerPadding)) {
                        composable ("watchList") { WatchListScreen(controller) }
                        composable ("detail") { DetailScreen(controller) }
                        composable ("writingReview") { WritingReviewScreen(controller) }
                    }
                }
            }
        }
    }
}


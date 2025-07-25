package com.example.moviereview.view


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.example.moviereview.R
import com.example.moviereview.viewModel.MainViewModel
import androidx.compose.runtime.getValue


@Composable
fun ProfileScreen(
    controller: NavHostController,
    viewModel: MainViewModel
) {

    val currentUser by viewModel.currentUser.collectAsState()

    Scaffold (
        Modifier
            .safeDrawingPadding()
            .fillMaxSize(),
        bottomBar = { BottomBar(navController = controller) }
    ) {
        LazyColumn (Modifier.padding(it)) {
            item {
                Image(
                    painter = painterResource(id = R.drawable.ic_profilee),
                    contentDescription = null,
                    modifier = Modifier
                        .size(300.dp)
                        .clip(CircleShape)
                        .border(3.dp, Color.Gray, CircleShape)
                        .padding(20.dp),
                    alignment = Alignment.TopCenter
                )
            }
        }
    }
}





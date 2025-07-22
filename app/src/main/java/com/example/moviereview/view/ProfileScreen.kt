package com.example.moviereview.view

//import androidx.compose.runtime.Composable
//import androidx.compose.ui.tooling.preview.Preview
//
//@Preview
//@Composable
//fun ProfileScreen() {
//
//}

import android.content.Context
import android.graphics.drawable.shapes.Shape
import android.os.Build
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import android.util.DisplayMetrics
import android.view.WindowManager
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.example.moviereview.R


@Composable
fun ProfileScreen(controller: NavHostController) {
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





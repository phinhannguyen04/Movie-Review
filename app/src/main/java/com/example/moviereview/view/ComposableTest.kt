package com.example.moviereview.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.example.moviereview.R


//@Composable
//fun MovieItem(
//    title: String,
//    imageRes: Int,
//    rating: String,
//    year: String
//) {
//    Row(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(vertical = 8.dp, horizontal = 8.dp),
//        verticalAlignment = Alignment.CenterVertically
//    ) {
//
//        Row (
//            Modifier.size(64.dp)
//        ) {
//            Image(
//                painter = painterResource(imageRes),
//                contentDescription = null,
//                modifier = Modifier.fillMaxSize(),
//                contentScale = ContentScale.Crop
//            )
//        }
//
//        Column (
//            Modifier
//                .padding(start = 16.dp)
//                .fillMaxWidth()
//                .wrapContentHeight(),
//            verticalArrangement = Arrangement.SpaceBetween
//        ) {
//
//            Text(
//                title,
//                modifier = Modifier
//                    .padding(bottom = 16.dp),
//                fontWeight = FontWeight.SemiBold,
//                fontSize = 20.sp
//            )
//
//            Row (
//                Modifier
//                    .fillMaxWidth(),
//            ) {
//                Row (
//                    Modifier
//                        .weight(0.5f)
//                ) {
//                    Icon(
//                        Icons.Default.Star,
//                        contentDescription = null,
//                        tint = MaterialTheme.colorScheme.secondary,
//                        modifier = Modifier.size(16.dp)
//                    )
//                    Text(rating, fontSize = 14.sp, modifier = Modifier.padding(start = 4.dp))
//                }
//                Row (
//                    Modifier
//                        .weight(0.5f)
//                ) {
//                    Icon(
//                        Icons.Default.DateRange,
//                        contentDescription = null,
//                        tint = MaterialTheme.colorScheme.primary,
//                        modifier = Modifier.size(16.dp)
//                    )
//                    Text(year, fontSize = 14.sp, modifier = Modifier.padding(start = 4.dp))
//                }
//            }
//        }
//    }
//}
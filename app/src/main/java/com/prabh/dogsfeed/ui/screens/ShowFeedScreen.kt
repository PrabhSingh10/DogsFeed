package com.prabh.dogsfeed.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import com.prabh.dogsfeed.utils.CommonButton
import com.prabh.dogsfeed.viewModel.DogsViewmodel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShowFeedScreen(navController: NavController, viewModel: DogsViewmodel) {

    val recentDogs = viewModel.recentDogsList.collectAsState()
    viewModel.fetchDogList()
    viewModel.clearOldCache()

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar (
                title = {
                    Text(
                        text = "Generate Dogs!",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Default.ArrowBack,
                            contentDescription = "Back Arrow"
                        )
                    }
                },
                modifier = Modifier
                    .background(Color(0XFFF8F9F8))
                    .shadow(elevation = 1.dp)
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LazyRow {
                recentDogs.value?.let {
                    items(it) { randomDog ->
                        AsyncImage(
                            model = randomDog.dogImageUrl,
                            contentDescription = "Cached Dog Image",
                            modifier = Modifier
                                .size(300.dp)
                                .padding(horizontal = 10.dp),
                            contentScale = ContentScale.Crop
                        )
                    }
                }
            }
            CommonButton(
                text = "Clear Dogs!"
            ) {
                viewModel.clearCache()
            }
        }
    }

}
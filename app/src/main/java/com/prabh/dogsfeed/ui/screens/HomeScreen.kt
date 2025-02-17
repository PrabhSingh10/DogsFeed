package com.prabh.dogsfeed.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.prabh.dogsfeed.utils.CommonButton
import com.prabh.dogsfeed.utils.CommonTextView

@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(1f))
        CommonTextView()
        Spacer(modifier = Modifier.weight(1f))
        CommonButton("Generate Dogs!") {
            navController.navigate("generateScreen")
        }
        Spacer(modifier = Modifier.height(10.dp))
        CommonButton("My Recently Generated Dogs!") {
            navController.navigate("showFeedScreen")
        }
        Spacer(modifier = Modifier.weight(1f))
    }
}
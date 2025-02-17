package com.prabh.dogsfeed.ui.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.prabh.dogsfeed.data.DogsDatabase
import com.prabh.dogsfeed.data.DogsRepository
import com.prabh.dogsfeed.ui.theme.DogsFeedTheme
import com.prabh.dogsfeed.viewModel.DogsViewmodel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DogsFeedTheme {
                DogsFeedApp(
                    viewmodel = DogsViewmodel(
                        DogsRepository(DogsDatabase.getDatabase(this).dogsDao())
                    )
                )
            }
        }
    }

}

@Composable
fun DogsFeedApp(viewmodel: DogsViewmodel) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") {
            HomeScreen(navController)
        }
        composable("generateScreen") {
            GenerateFeedScreen(
                navController = navController,
                viewModel = viewmodel
            )
        }
        composable("showFeedScreen") {
            ShowFeedScreen(
                navController = navController,
                viewModel = viewmodel
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DogsFeedTheme {

    }
}
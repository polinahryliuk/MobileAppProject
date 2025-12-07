package com.frenchflashcardsproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.frenchflashcardsproject.ui.screens.AddCardScreen
import com.frenchflashcardsproject.ui.theme.FrenchFlashcardsProjectTheme
import com.frenchflashcardsproject.ui.theme.navigation.Screen
import com.frenchflashcardsproject.ui.theme.screens.HomeScreen
import com.frenchflashcardsproject.ui.theme.screens.ReviewScreen
import com.frenchflashcardsproject.ui.theme.screens.SettingsScreen
import com.frenchflashcardsproject.ui.theme.screens.StatsScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FrenchFlashcardsProjectTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    FlashcardsApp()
                }
            }
        }
    }
    @Composable
    fun FlashcardsApp() {
        val navController = rememberNavController()

        NavHost(
            navController = navController,
            startDestination = Screen.Home.route
        ) {
            composable(Screen.Home.route) {
                HomeScreen(navController = navController)
            }
            composable(Screen.AddCard.route) {
                AddCardScreen(navController = navController)
            }
            composable(Screen.Review.route) {
                ReviewScreen(navController = navController)
            }
            composable(Screen.Stats.route) {
                StatsScreen(navController = navController)
            }
            composable(Screen.Settings.route) {
                SettingsScreen(navController = navController)
            }
        }
    }
}


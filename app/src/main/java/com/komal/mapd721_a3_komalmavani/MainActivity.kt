package com.komal.mapd721_a3_komalmavani

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.komal.mapd721_a3_komalmavani.navigation.Screen
import com.komal.mapd721_a3_komalmavani.ui.screens.AnimatedContentScreen
import com.komal.mapd721_a3_komalmavani.ui.screens.GestureAnimationScreen
import com.komal.mapd721_a3_komalmavani.ui.screens.HomeScreen
import com.komal.mapd721_a3_komalmavani.ui.screens.InfiniteAnimationScreen
import com.komal.mapd721_a3_komalmavani.ui.screens.ValueBasedAnimationScreen
import com.komal.mapd721_a3_komalmavani.ui.theme.MAPD721A3KomalMavaniTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MAPD721A3KomalMavaniTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavigation()
                }
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) {
            HomeScreen(navController)
        }
        composable(Screen.AnimatedContent.route) {
            AnimatedContentScreen(navController)
        }
        composable(Screen.ValueBasedAnimation.route) {
            ValueBasedAnimationScreen(navController)
        }
        composable(Screen.InfiniteTransition.route) {
            InfiniteAnimationScreen(navController)
        }
        composable(Screen.GestureBasedAnimation.route) {
            GestureAnimationScreen(navController)
        }
    }
}
package com.komal.mapd721_a3_komalmavani.ui.screens

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.komal.mapd721_a3_komalmavani.navigation.Screen

@Composable
fun HomeScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(Color(0xFF6A11CB), Color(0xFF2575FC))
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth()
                .shadow(8.dp, RoundedCornerShape(16.dp))
                .background(Color.White, RoundedCornerShape(16.dp))
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "MAPD721 - Assignment 3",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF6A11CB)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Komal Mavani",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.DarkGray
            )

            Text(
                text = "Student ID: 301472922",
                fontSize = 18.sp,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(24.dp))

            val buttons = listOf(
                "Animated Content" to Screen.AnimatedContent.route,
                "Value Based Animation" to Screen.ValueBasedAnimation.route,
                "Infinite Transition" to Screen.InfiniteTransition.route,
                "Gesture Based Animation" to Screen.GestureBasedAnimation.route
            )

            buttons.forEach { (label, route) ->
                AnimatedButton(label) { navController.navigate(route) }
                Spacer(modifier = Modifier.height(12.dp))
            }
        }
    }
}

@Composable
fun AnimatedButton(text: String, onClick: () -> Unit) {
    var isClicked by remember { mutableStateOf(false) }

    Button(
        onClick = {
            isClicked = !isClicked
            onClick()
        },
        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize()
            .shadow(if (isClicked) 12.dp else 4.dp, RoundedCornerShape(12.dp)),
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2575FC))
    ) {
        Text(
            text = text,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
    }
}
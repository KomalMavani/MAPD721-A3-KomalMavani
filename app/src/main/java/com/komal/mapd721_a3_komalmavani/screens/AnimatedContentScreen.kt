package com.komal.mapd721_a3_komalmavani.ui.screens

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
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

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AnimatedContentScreen(navController: NavController) {
    var counter by remember { mutableStateOf(0) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(Color(0xFF4A148C), Color(0xFF7B1FA2))
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
                text = "Animated Content Example",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF4A148C)
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Animated Content block with smooth transition
            AnimatedContent(
                targetState = counter,
                transitionSpec = { fadeIn(animationSpec = tween(300)) with fadeOut(animationSpec = tween(300)) }
            ) { count ->
                Text(
                    text = "Count: $count",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.DarkGray
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Buttons to update the counter
            AnimationActionButton("Increase") { counter++ }
            Spacer(modifier = Modifier.height(10.dp))
            AnimationActionButton("Decrease") { counter-- }

            Spacer(modifier = Modifier.height(30.dp))

            AnimationActionButton("Back to Main Screen") { navController.popBackStack() }
        }
    }
}

@Composable
fun AnimationActionButton(text: String, onClick: () -> Unit) {
    var isPressed by remember { mutableStateOf(false) }

    Button(
        onClick = {
            isPressed = !isPressed
            onClick()
        },
        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize()
            .shadow(if (isPressed) 10.dp else 4.dp, RoundedCornerShape(12.dp))
            .padding(horizontal = 8.dp),
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6A1B9A))
    ) {
        Text(
            text = text,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
    }
}
package com.komal.mapd721_a3_komalmavani.ui.screens

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController

@Composable
fun InfiniteAnimationScreen(navController: NavController) {
    val infiniteTransition = rememberInfiniteTransition()

    // Scaling animation (Pulsing effect)
    val scale by infiniteTransition.animateFloat(
        initialValue = 0.8f,
        targetValue = 1.2f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        )
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(Color(0xFF303F9F), Color(0xFF7C4DFF))
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
                text = "Infinite Animation",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF303F9F)
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Pulsing Circle
            Box(
                modifier = Modifier
                    .size(120.dp)
                    .scale(scale),
                contentAlignment = Alignment.Center
            ) {
                Surface(
                    modifier = Modifier.size(120.dp),
                    color = Color(0xFF4CAF50),
                    shape = CircleShape,
                    shadowElevation = 8.dp
                ) {}
            }

            Spacer(modifier = Modifier.height(30.dp))

            InfiniteActionButton("Back to Main Screen") { navController.popBackStack() }
        }
    }
}

@Composable
fun InfiniteActionButton(text: String, onClick: () -> Unit) {
    var isPressed by remember { mutableStateOf(false) }

    Button(
        onClick = {
            isPressed = !isPressed
            onClick()
        },
        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize()
            .shadow(if (isPressed) 12.dp else 4.dp, RoundedCornerShape(12.dp))
            .padding(horizontal = 8.dp),
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF7C4DFF))
    ) {
        Text(
            text = text,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
    }
}
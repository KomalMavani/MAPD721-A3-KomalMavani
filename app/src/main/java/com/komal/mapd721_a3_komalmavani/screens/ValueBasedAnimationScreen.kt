package com.komal.mapd721_a3_komalmavani.ui.screens

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ValueBasedAnimationScreen(navController: NavController) {
    var isVisible by remember { mutableStateOf(true) }
    val transition = updateTransition(targetState = isVisible, label = "Visibility Transition")

    val scale by transition.animateFloat(
        transitionSpec = { tween(durationMillis = 500) },
        label = "Scale Animation"
    ) { state -> if (state) 1f else 0f }

    val color by transition.animateColor(
        transitionSpec = { tween(durationMillis = 500) },
        label = "Color Animation"
    ) { state -> if (state) Color(0xFF4CAF50) else Color(0xFFD32F2F) } // Green & Red colors

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(Color(0xFF3F51B5), Color(0xFF7E57C2))
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
                text = "Value-Based Animation",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF3F51B5)
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Animated Circle
            Box(
                modifier = Modifier
                    .size(120.dp)
                    .scale(scale),
                contentAlignment = Alignment.Center
            ) {
                Surface(
                    modifier = Modifier.size(120.dp),
                    color = color,
                    shape = CircleShape,
                    shadowElevation = 10.dp
                ) {}
            }

            Spacer(modifier = Modifier.height(20.dp))

            ValueBasedActionButton("Toggle Animation") { isVisible = !isVisible }

            Spacer(modifier = Modifier.height(30.dp))

            ValueBasedActionButton("Back to Main Screen") { navController.popBackStack() }
        }
    }
}

@Composable
fun ValueBasedActionButton(text: String, onClick: () -> Unit) {
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
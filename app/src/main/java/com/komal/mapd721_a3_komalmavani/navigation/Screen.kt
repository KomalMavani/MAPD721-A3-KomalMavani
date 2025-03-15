package com.komal.mapd721_a3_komalmavani.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object AnimatedContent : Screen("animated_content")
    object ValueBasedAnimation : Screen("value_based")
    object InfiniteTransition : Screen("infinite_transition")
    object GestureBasedAnimation : Screen("gesture_based")
} 
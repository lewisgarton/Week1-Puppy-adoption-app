package com.example.androiddevchallenge

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable(
            "home"
        ) {
            HomeScreen(navController = navController)
        }
        composable("kittenProfile/{kittenId}",
            arguments = listOf(navArgument("kittenId") { type = NavType.IntType })
        ) { backStackEntry ->
            KittenProfile(backStackEntry.arguments?.getInt("kittenId"))
        }
    }
}

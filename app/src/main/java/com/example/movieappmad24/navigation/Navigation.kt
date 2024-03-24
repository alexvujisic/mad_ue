package com.example.movieappmad24.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.movieappmad24.screens.DetailScreen
import com.example.movieappmad24.screens.HomeScreen
import com.example.movieappmad24.screens.WatchlistScreen


sealed class Screen(val route: String) {
    object Home : Screen("homescreen")
    object Details : Screen("detailscreen")

    object Watchlist : Screen("watchlist")
}


@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) {
            HomeScreen(navController)
        }
        composable(Screen.Details.route + "/{movieId}",
            arguments = listOf(navArgument("movieId") { type = NavType.StringType })) { backStackEntry ->
            val movieId = backStackEntry.arguments?.getString("movieId")
            DetailScreen(movieId = movieId, navController = navController)
        }
        composable(Screen.Watchlist.route){
            WatchlistScreen(navController)
        }
    }
}

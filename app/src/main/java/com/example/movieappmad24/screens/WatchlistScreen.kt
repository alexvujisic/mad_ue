package com.example.movieappmad24.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.movieappmad24.models.getMovies
import com.example.movieappmad24.models.getWatchlistMovies
import com.example.movieappmad24.navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WatchlistScreen(navController: NavController) {
    Scaffold (
        topBar = {
            SimpleTopAppBar(title = "Watchlist", false, navController)
        },
        bottomBar = {
            SimpleBottomAppBar(navController)
        }
    ){ innerPadding ->
        MovieList(
            modifier = Modifier.padding(innerPadding),
            movies = getWatchlistMovies(),
            navController = navController
        )
    }
}
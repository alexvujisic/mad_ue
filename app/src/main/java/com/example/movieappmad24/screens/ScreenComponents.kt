package com.example.movieappmad24.screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.movieappmad24.navigation.Screen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SimpleTopAppBar(title: String?, showBackButton: Boolean = false, navController: NavController){
    CenterAlignedTopAppBar(
        title = { title?.let { Text(it) } },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary
        ),
        navigationIcon = {
            if (showBackButton){
                IconButton(onClick = { navController.navigateUp() }) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "arrowback"
                    )
                }
            }
        }
    )
}

@Composable
fun SimpleBottomAppBar(navController: NavController){
    val currentScreen = navController.currentBackStackEntryAsState().value?.destination?.route
    NavigationBar {
        NavigationBarItem(
            label = { Text("Home") },
            selected = currentScreen == Screen.Home.route,
            onClick = { navController.navigate(Screen.Home.route) },
            icon = { Icon(
                imageVector = Icons.Filled.Home,
                contentDescription = "Go to home"
            )
            }
        )
        NavigationBarItem(
            label = { Text("Watchlist") },
            selected = currentScreen == Screen.Watchlist.route,
            onClick = {navController.navigate(Screen.Watchlist.route)},
            icon = { Icon(
                imageVector = Icons.Filled.Star,
                contentDescription = "Go to watchlist"
            )
            }
        )
    }
}
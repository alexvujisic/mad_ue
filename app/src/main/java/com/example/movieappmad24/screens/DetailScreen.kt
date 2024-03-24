package com.example.movieappmad24.screens


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.movieappmad24.models.Movie
import com.example.movieappmad24.models.getMovies

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(movieId: String?, navController: NavController) {
    Scaffold (
        topBar = {
            SimpleTopAppBar(title = getMovieById(movieId)?.title, true, navController = navController)
        }
    ){innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            getMovieById(movieId)?.let {
                MovieRow(movie = it)
            }
            DisplayMovieImages(movieId)
        }
    }
}


fun getMovieById(id: String?): Movie? {
    val movieList = getMovies()
    return movieList.find { it.id == id }
}

@Composable
fun DisplayMovieImages(id: String?){
    LazyRow(modifier = Modifier){
        val imageList = getMovieById(id)?.images
        imageList?.let { list ->
            items(list) { image ->
                Box(
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .clip(RoundedCornerShape(8.dp))
                ) {
                    MovieImage(imageUrl = image)
                }
            }
        }
    }
}




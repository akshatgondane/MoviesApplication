package com.example.moviesapp.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.UserApiService
import com.example.moviesapp.Model.Movie
import kotlinx.coroutines.launch

class MovieViewModel: ViewModel()
{
    var movieListResponse: List<Movie> by mutableStateOf(listOf())
    var errorMessage: String by mutableStateOf("")

    fun getMovieList()
    {
        viewModelScope.launch {
            val userApiService = UserApiService.getInstance()
            try {
                val movieList = userApiService.getMovies()
                movieListResponse = movieList
            }
            catch (e: java.lang.Exception)
            {
                errorMessage = e.message.toString()
            }
        }
    }
}
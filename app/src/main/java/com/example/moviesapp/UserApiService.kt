package com.example.moviesapp

import com.example.moviesapp.Model.Movie
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


interface UserApiService
{
    @GET("movielist.json")
    suspend fun getMovies(): List<Movie>

    companion object{
        var userApiService:UserApiService? = null
        fun getInstance(): UserApiService
        {
            if(userApiService == null)
            {
                userApiService = Retrofit.Builder()
                    .baseUrl("https://gorest.co.in/public/v2/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(UserApiService::class.java)
            }

            return userApiService!!
        }
    }
}
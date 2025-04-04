package com.example.testtasksekvenia.data.remote.api

import com.example.testtasksekvenia.model.Film
import retrofit2.Response
import retrofit2.http.GET


interface FilmApi {

    @GET("sequeniatesttask/films.json")
    suspend fun fetchFilmList(): Response<List<Film>>

}

package com.example.testtasksequenia.data.remote.api

import com.example.testtasksequenia.model.FilmResponse
import retrofit2.Response
import retrofit2.http.GET


interface FilmApi {

    @GET("sequeniatesttask/films.json")
    suspend fun fetchFilmList(): Response<FilmResponse>

}

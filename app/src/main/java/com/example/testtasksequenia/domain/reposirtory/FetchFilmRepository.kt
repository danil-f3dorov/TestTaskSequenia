package com.example.testtasksequenia.domain.reposirtory

import com.example.testtasksequenia.model.FilmResponse
import retrofit2.Response

interface FetchFilmRepository {
    suspend fun fetchFilmList(): Response<FilmResponse>
}
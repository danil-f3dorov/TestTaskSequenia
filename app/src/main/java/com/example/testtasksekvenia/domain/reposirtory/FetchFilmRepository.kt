package com.example.testtasksekvenia.domain.reposirtory

import com.example.testtasksekvenia.model.Film
import retrofit2.Response

interface FetchFilmRepository {

    suspend fun fetchFilmList(): Response<List<Film>>
}
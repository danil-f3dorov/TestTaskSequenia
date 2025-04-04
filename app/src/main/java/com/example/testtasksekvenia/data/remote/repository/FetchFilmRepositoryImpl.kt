package com.example.testtasksekvenia.data.remote.repository

import com.example.testtasksekvenia.data.remote.api.FilmApi
import com.example.testtasksekvenia.domain.reposirtory.FetchFilmRepository
import com.example.testtasksekvenia.model.Film
import retrofit2.Response


class FetchFilmRepositoryImpl(
    private val filmApi: FilmApi
) : FetchFilmRepository {

    override suspend fun fetchFilmList(): Response<List<Film>> {
        return filmApi.fetchFilmList()
    }
}
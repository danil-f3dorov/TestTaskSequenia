package com.example.testtasksequenia.data.remote.repository

import com.example.testtasksequenia.data.remote.api.FilmApi
import com.example.testtasksequenia.domain.reposirtory.FetchFilmRepository
import com.example.testtasksequenia.model.FilmResponse
import retrofit2.Response


class FetchFilmRepositoryImpl(
    private val filmApi: FilmApi
) : FetchFilmRepository {

    override suspend fun fetchFilmList(): Response<FilmResponse> {
        return filmApi.fetchFilmList()
    }
}
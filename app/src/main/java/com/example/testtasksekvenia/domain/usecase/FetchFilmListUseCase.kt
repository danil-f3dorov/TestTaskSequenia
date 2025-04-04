package com.example.testtasksekvenia.domain.usecase

import com.example.testtasksekvenia.data.remote.api.FilmApi
import com.example.testtasksekvenia.model.Film
import retrofit2.Response

class FetchFilmListUseCase(private val filmApi: FilmApi) {
    suspend operator fun invoke(): Result<Response<List<Film>>> =
        runCatching {
            filmApi.fetchFilmList()
        }.recoverCatching { throwable ->
            throw throwable
        }
}
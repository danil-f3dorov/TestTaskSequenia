package com.example.testtasksequenia.domain.usecase

import com.example.testtasksequenia.domain.reposirtory.FetchFilmRepository
import com.example.testtasksequenia.model.FilmResponse
import retrofit2.Response

class FetchFilmListUseCase(private val fetchFilmRepository: FetchFilmRepository) {
    suspend operator fun invoke(): Result<Response<FilmResponse>> =
        runCatching {
            fetchFilmRepository.fetchFilmList()
        }.recoverCatching { throwable ->
            throw throwable
        }
}
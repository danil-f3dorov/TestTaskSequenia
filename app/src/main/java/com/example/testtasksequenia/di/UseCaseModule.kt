package com.example.testtasksequenia.di

import com.example.testtasksequenia.domain.usecase.FetchFilmListUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single<FetchFilmListUseCase> {
        FetchFilmListUseCase(get())
    }
}
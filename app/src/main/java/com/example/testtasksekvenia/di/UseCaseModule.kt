package com.example.testtasksekvenia.di

import com.example.testtasksekvenia.domain.usecase.FetchFilmListUseCase
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module

val useCaseModule = module {
    single<FetchFilmListUseCase> {
        FetchFilmListUseCase(get())
    }
}
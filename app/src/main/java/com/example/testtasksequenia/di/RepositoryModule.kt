package com.example.testtasksequenia.di

import com.example.testtasksequenia.data.remote.repository.FetchFilmRepositoryImpl
import com.example.testtasksequenia.domain.reposirtory.FetchFilmRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<FetchFilmRepository> {
        FetchFilmRepositoryImpl(get())
    }
}
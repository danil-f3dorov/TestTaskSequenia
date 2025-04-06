package com.example.testtasksequenia

import android.app.Application
import com.example.testtasksequenia.di.networkModule
import com.example.testtasksequenia.di.repositoryModule
import com.example.testtasksequenia.di.useCaseModule
import com.example.testtasksequenia.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class TestTaskApp: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@TestTaskApp)
            modules(networkModule, useCaseModule, viewModelModule, repositoryModule)
        }
    }
}
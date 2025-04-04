package com.example.testtasksekvenia

import android.app.Application
import com.example.testtasksekvenia.di.networkModule
import com.example.testtasksekvenia.di.useCaseModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class TestTaskApp: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@TestTaskApp)
            modules(networkModule, useCaseModule)
        }
    }
}
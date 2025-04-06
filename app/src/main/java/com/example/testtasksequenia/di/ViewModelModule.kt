package com.example.testtasksequenia.di

import com.example.testtasksequenia.vm.MainViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel<MainViewModel> {
        MainViewModel(get())
    }
}
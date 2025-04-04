package com.example.testtasksekvenia

import androidx.lifecycle.ViewModel
import com.example.testtasksekvenia.model.Film
import kotlinx.coroutines.flow.MutableStateFlow

class MainViewModel: ViewModel() {

    private val filmList = MutableStateFlow<List<Film>>(emptyList())



    fun fetchFilmList() {

    }
}
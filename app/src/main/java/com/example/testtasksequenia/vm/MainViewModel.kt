package com.example.testtasksequenia.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testtasksequenia.domain.usecase.FetchFilmListUseCase
import com.example.testtasksequenia.model.Film
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

enum class LoadStatus {
    LOADING, FINISH, ERROR
}

class MainViewModel(
    private val fetchFilmListUseCase: FetchFilmListUseCase
) : ViewModel() {

    private val _loadStatus = MutableStateFlow<LoadStatus>(LoadStatus.LOADING)
    val loadStatus = _loadStatus

    private val _filmList = MutableStateFlow<List<Film>>(emptyList())

    private val _filterByGenre = MutableStateFlow<List<Film>>(emptyList())
    val filterByGenre = _filterByGenre

    private val _genresList = MutableStateFlow<List<String>>(emptyList())
    val genresList = _genresList

    private val _selectedFilm = MutableStateFlow<Film?>(null)
    val selectedFilm get() = _selectedFilm

    init {
        fetchFilmList()
    }

    fun fetchFilmList() {
        _loadStatus.value = LoadStatus.LOADING
        viewModelScope.launch(Dispatchers.IO) {
            fetchFilmListUseCase.invoke().fold(
                onSuccess = { response ->
                    _filmList.value = response.body()?.films!!.sortedBy { it.localized_name }
                    _filterByGenre.value = _filmList.value
                    updateGenres()
                    _loadStatus.value = LoadStatus.FINISH
                },
                onFailure = {
                    _loadStatus.value = LoadStatus.ERROR
                }
            )
        }
    }

    private fun updateGenres() {
        val newGenres = _filmList.value
            .flatMap { film -> film.genres }
            .distinct()
            .sorted()
        _genresList.value = newGenres
    }

    fun filterByGenre(genre: String) {
        _filterByGenre.value = _filmList.value.filter {
            it.genres.any { it.contains(genre, ignoreCase = true) }
        }
    }

    fun toggleFilterByGenre() {
        _filterByGenre.value = _filmList.value
    }

    fun selectFilm(film: Film) {
        _selectedFilm.value = film
    }
}
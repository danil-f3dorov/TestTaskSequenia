package com.example.testtasksequenia.fragment.catalog

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.testtasksequenia.compose.MySnackbar
import com.example.testtasksequenia.compose.TopAppBar
import com.example.testtasksequenia.compose.film.FilmsColumn
import com.example.testtasksequenia.compose.genre.GenresColumn
import com.example.testtasksequenia.ui.theme.yellow
import com.example.testtasksequenia.vm.LoadStatus
import com.example.testtasksequenia.vm.MainViewModel

@Composable
fun FilmCatalogScreen(
    viewModel: MainViewModel,
    navDetails: () -> Unit
) {
    val loadStatus = viewModel.loadStatus.collectAsState()
    val snackBarHostState = remember { SnackbarHostState() }

    LaunchedEffect(loadStatus.value) {
        when (loadStatus.value) {
            LoadStatus.ERROR -> {
                val result = snackBarHostState.showSnackbar(
                    message = "Ошибка подключения сети",
                    actionLabel = "ПОВТОРИТЬ",
                    duration = SnackbarDuration.Indefinite
                )
                if (result == SnackbarResult.ActionPerformed) {
                    viewModel.fetchFilmList()
                }
            }

            LoadStatus.LOADING -> snackBarHostState.currentSnackbarData?.dismiss()
            else -> {}
        }
    }

    Scaffold(
        topBar = { TopAppBar("Фильмы") },
        snackbarHost = {
            SnackbarHost(hostState = snackBarHostState) { data ->
                MySnackbar {
                    viewModel.fetchFilmList()
                }
            }
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentAlignment = Alignment.Center
        ) {
            when (loadStatus.value) {
                LoadStatus.LOADING -> CircularProgressIndicator(color = yellow)
                LoadStatus.FINISH -> FilmCatalogContent(viewModel, navDetails)
                LoadStatus.ERROR -> {}
            }
        }
    }
}

@Composable
private fun FilmCatalogContent(
    viewModel: MainViewModel,
    navDetails: () -> Unit
) {
    val genresList = viewModel.genresList.collectAsState()
    val filmList = viewModel.filterByGenre.collectAsState()

    Column(
        Modifier
            .verticalScroll(rememberScrollState())
            .padding(vertical = 16.dp)
    ) {
        GenresColumn(
            genres = genresList.value,
            onGenreSelected = {
                viewModel.filterByGenre(it)
            },
            onDoubleClick = {
                viewModel.toggleFilterByGenre()
            })

        Spacer(Modifier.height(16.dp))
        FilmsColumn(
            filmList.value,
            selectFilm = {
                viewModel.selectFilm(it)
            },
            navDetails = navDetails
        )
    }
}
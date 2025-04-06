package com.example.testtasksequenia.compose.film

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testtasksequenia.model.Film

@Composable
fun FilmsColumn(
    films: List<Film>,
    navDetails: () -> Unit,
    selectFilm: (Film) -> Unit
) {
    val rows = films.chunked(2)

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "Фильмы",
            fontWeight = FontWeight.W700,
            fontSize = 20.sp,
            color = Color.Black,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Spacer(Modifier.height(16.dp))

        Column(
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            rows.forEach { rowFilms ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    FilmItem(
                        modifier = Modifier.weight(1f),
                        film = rowFilms[0],
                        navDetails = {
                            selectFilm(rowFilms[0])
                            navDetails()
                        }
                    )

                    if (rowFilms.size > 1) {
                        FilmItem(
                            modifier = Modifier.weight(1f),
                            film = rowFilms[1],
                            navDetails = {
                                selectFilm(rowFilms[1])
                                navDetails()
                            }
                        )
                    } else {
                        Spacer(Modifier.weight(1f))
                    }
                }
            }
        }
    }
}
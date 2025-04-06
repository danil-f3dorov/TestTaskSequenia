package com.example.testtasksequenia.compose.genre

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun GenresColumn(
    genres: List<String>,
    onGenreSelected: (String) -> Unit,
    onDoubleClick: () -> Unit
) {

    var selectedGenre by rememberSaveable { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = "Жанры",
            fontWeight = FontWeight.W700,
            fontSize = 20.sp,
            color = Color.Black,
            modifier = Modifier.padding(start = 16.dp)
        )

        Spacer(Modifier.height(16.dp))

        Column {
            genres.forEach {
                GenreItem(
                    genre = it,
                    isSelected = it == selectedGenre,
                    onClick = {
                        selectedGenre = it
                        onGenreSelected(it)
                    },
                    onDoubleClick = {
                        selectedGenre = null
                        onDoubleClick()
                    }
                )
            }
        }

    }
}

@Composable
@Preview()
fun GenresColumnPreview() {
    GenresColumn(
        listOf("abc", "def", "qwe", "asd", "zxc"),
        {}, {})
}












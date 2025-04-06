package com.example.testtasksequenia.compose.genre

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testtasksequenia.ui.theme.yellow

@Composable
fun GenreItem(
    genre: String,
    isSelected: Boolean,
    onClick: () -> Unit,
    onDoubleClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp)
            .background(if (isSelected) yellow else Color.White)
            .clickable(
                onClick = if (isSelected) onDoubleClick else onClick
            ),
        contentAlignment = Alignment.CenterStart
    ) {
        Text(
            text = genre.replaceFirstChar { it.uppercase() },
            fontWeight = FontWeight.W400,
            fontSize = 16.sp,
            color = Color.Black,
            modifier = Modifier.padding(start = 16.dp)
        )
    }
}

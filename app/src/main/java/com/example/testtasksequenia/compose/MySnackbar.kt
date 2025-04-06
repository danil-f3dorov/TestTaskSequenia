package com.example.testtasksequenia.compose

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testtasksequenia.ui.theme.black1
import com.example.testtasksequenia.ui.theme.yellow

@Composable
fun MySnackbar(
    fetchFilmList: () -> Unit
) {
    Snackbar(
        modifier = Modifier.padding(8.dp),
        containerColor = black1,
        contentColor = Color.White,
        action = {
            TextButton(
                onClick = { fetchFilmList() },
                interactionSource = NoRippleInteractionSource,
                colors = ButtonDefaults.textButtonColors(
                    contentColor = yellow
                )
            ) {
                Text(
                    text = "ПОВТОРИТЬ",
                    fontWeight = FontWeight.W500,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(vertical = 12.dp)
                )
            }
        }
    ) {
        Text(
            text = "Ошибка подключения сети",
            fontWeight = FontWeight.W400,
            fontSize = 15.sp
        )
    }
}
package com.example.testtasksequenia.compose.film

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.testtasksequenia.R
import com.example.testtasksequenia.compose.NoRippleInteractionSource
import com.example.testtasksequenia.model.Film

@Composable
fun FilmItem(
    modifier: Modifier,
    film: Film,
    navDetails: () -> Unit
) {
    Column(
        modifier
        .clickable(
            indication = null,
            interactionSource = NoRippleInteractionSource,
            onClick = {
                navDetails()
            }
        )) {
        Image(
            painter = rememberAsyncImagePainter(
                model = film.image_url,
                error = painterResource(R.drawable.img),
                placeholder = painterResource(R.drawable.img)
            ),
            contentDescription = "${film.name} image",
            modifier = Modifier
                .fillMaxWidth()
                .height(222.dp)
                .clip(RoundedCornerShape(4.dp)),
            contentScale = ContentScale.FillBounds
        )
        Spacer(Modifier.height(8.dp))
        Text(
            text = film.localized_name,
            fontWeight = FontWeight.W700,
            fontSize = 16.sp,
            color = Color.Black,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
        Spacer(Modifier.height(20.dp))
    }
}
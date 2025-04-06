package com.example.testtasksequenia.fragment.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.testtasksequenia.vm.MainViewModel
import com.example.testtasksequenia.R
import com.example.testtasksequenia.compose.TopAppBar
import com.example.testtasksequenia.ui.theme.blue
import com.example.testtasksequenia.ui.theme.gray

@Composable
fun FilmDetailsScreen(
    viewModel: MainViewModel,
    popBackStack: () -> Unit
) {

    val selectedFilm = viewModel.selectedFilm.collectAsState().value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.Start
    ) {
        TopAppBar(
            title = selectedFilm?.name ?: "",
            onClick = popBackStack
        )
        Column(
            Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {

            Spacer(Modifier.height(24.dp))

            Image(
                painter = rememberAsyncImagePainter(
                    model = selectedFilm?.image_url,
                    error = painterResource(R.drawable.img),
                    placeholder = painterResource(R.drawable.img)
                ),
                contentDescription = "${selectedFilm?.name} image",
                modifier = Modifier
                    .height(200.dp)
                    .width(128.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .align(Alignment.CenterHorizontally),
                contentScale = ContentScale.FillBounds
            )

            Spacer(Modifier.height(24.dp))

            Text(
                text = selectedFilm?.localized_name ?: "",
                fontWeight = FontWeight.W700,
                fontSize = 26.sp,
                color = Color.Black
            )

            Spacer(Modifier.height(8.dp))

            Text(
                text = "${selectedFilm?.genres?.joinToString(", ")}, ${selectedFilm?.year} год",
                fontWeight = FontWeight.W400,
                fontSize = 16.sp,
                color = gray
            )

            Spacer(Modifier.height(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = selectedFilm?.rating?.let {
                        "%.1f".format(it)
                    } ?: "0.0",
                    fontWeight = FontWeight.W700,
                    fontSize = 24.sp,
                    color = blue
                )
                Text(
                    text = "КиноПоиск",
                    fontWeight = FontWeight.W500,
                    fontSize = 16.sp,
                    color = blue
                )
            }

            Spacer(Modifier.height(14.dp))

            Text(
                text = selectedFilm?.description ?: "",
                fontWeight = FontWeight.W400,
                fontSize = 14.sp,
                color = Color.Black
            )

            Spacer(Modifier.height(15.dp))

        }
    }
}
package com.example.testtasksequenia.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testtasksequenia.R
import com.example.testtasksequenia.ui.theme.blue

@Composable
fun TopAppBar(
    title: String,
    onClick: (() -> Unit)? = null
) {
    Box(
        Modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(blue)
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.W500,
            fontSize = 18.sp,
            color = Color.White,
            modifier = Modifier.align(Alignment.Center).padding(horizontal = 65.dp),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )

        if (onClick != null) {
            Box(
                modifier = Modifier
                    .size(64.dp)
                    .clickable(
                        indication = null,
                        interactionSource = NoRippleInteractionSource ,
                        onClick = onClick
                    )
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_arrow_left),
                    contentDescription = "back",
                    tint = Color.White,
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .padding(start = 16.dp)
                )
            }
        }
    }
}
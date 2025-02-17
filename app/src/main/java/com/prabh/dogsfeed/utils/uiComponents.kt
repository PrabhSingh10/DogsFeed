package com.prabh.dogsfeed.utils

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CommonTextView() {
    Text(
        text = "Random Dog Generator!",
        fontSize = 20.sp
    )
}

@Composable
fun CommonButton(text: String, onClickAction: () -> Unit) {
    Button(
        border = BorderStroke(1.dp, Color.Black),
        shape = RoundedCornerShape(20.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color(
            red = 66f/255f,
            green = 134f/255f,
            blue = 244f/255f,
            alpha = 1f
        )
        ),
        onClick = { onClickAction() }
    ) {
        Text(
            text = text,
            style = TextStyle(
                color = Color.White
            )
        )
    }
}
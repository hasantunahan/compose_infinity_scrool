package com.example.compose_marvel.core.component.image

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun ImageAsset(_id: Int, _width: Dp??, _height: Dp??) {

    val image: Painter = painterResource(id = _id)
    Image(
        painter = image,
        contentDescription = "",
        Modifier.size(width = _width ?: 100.dp, height = _height ?: 100.dp)
    )

}
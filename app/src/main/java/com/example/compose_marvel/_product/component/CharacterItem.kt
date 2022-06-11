package com.example.compose_marvel._product.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.example.compose_marvel.network.model.CharacterResponseModel
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun CharacterItem(characters: CharacterResponseModel) {
    Row(modifier = Modifier.padding(12.dp)) {
        GlideImage(
            imageModel = "${characters.thumbnail.path}/portrait_xlarge.jpg",
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(width = 60.dp, height = 90.dp)
        )
        Text(characters.name)
    }
}
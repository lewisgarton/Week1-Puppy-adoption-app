package com.example.androiddevchallenge

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun KittenProfile(kittenId: Int?) {

    val kittenToDisplay = puppies.find {
        it.id == kittenId
    } ?: //fixme
    throw Exception("Resource Not Found... This is not good")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painterResource(
                id = kittenToDisplay.imageId
            ),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth(0.8F)
                .height(250.dp)
                .clip(RoundedCornerShape(30.dp)),
            contentScale = ContentScale.Crop,
        )

        Spacer(modifier = Modifier.height(40.dp))

        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(20.dp))
                .background(MaterialTheme.colors.secondary)
                .padding(30.dp, 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            Text(
                text = kittenToDisplay.name,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.h2
            )

            Spacer(modifier = Modifier.height(15.dp))

            Text(
                text = kittenToDisplay.age,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.h5
            )

            Spacer(modifier = Modifier.height(30.dp))

            Text(
                text = kittenToDisplay.description,
                style = MaterialTheme.typography.body1
            )
        }

    }

}

@Composable
@Preview
fun KittenProfilePreview() {
    KittenProfile(1)
}


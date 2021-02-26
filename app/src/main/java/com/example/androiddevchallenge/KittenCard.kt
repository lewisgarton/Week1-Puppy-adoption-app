package com.example.androiddevchallenge

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController

enum class Orientation {
    LEFT, RIGHT
}

@Composable
fun KittenCard(kitten: Kitten, orientation: Orientation, navController: NavController) {

    val sidedRoundedCornerShape = when (orientation) {
        Orientation.LEFT -> RoundedCornerShape(50.dp, 11.dp, 11.dp, 11.dp)
        Orientation.RIGHT -> RoundedCornerShape(11.dp, 11.dp, 50.dp, 11.dp)
    }


    Row(
        modifier = Modifier
            .clip(sidedRoundedCornerShape)
            .height(150.dp)
            .fillMaxWidth()
            .background(MaterialTheme.colors.secondary)
            .clickable {
                navController.navigate("kittenProfile/${kitten.id}")
            },
        verticalAlignment = Alignment.CenterVertically
    ) {


        val randomSpace = (200..500).random() / 10.0F
        when (orientation) {
            Orientation.LEFT -> {
                Image(
                    painterResource(
                        id = kitten.imageId
                    ),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth(0.5F),
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = kitten.name,
                    color = MaterialTheme.colors.primary,
                    modifier = Modifier
                        .fillMaxWidth(0.5F + randomSpace),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.h4
                )
            }
            Orientation.RIGHT -> {
                Spacer(modifier = Modifier.width(randomSpace.dp))
                Text(
                    text = kitten.name,
                    color = MaterialTheme.colors.primary,
                    modifier = Modifier
                        .fillMaxWidth(0.5F),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.h4
                )
                Spacer(modifier = Modifier.width(randomSpace.dp))
                Image(
                    painterResource(
                        id = kitten.imageId
                    ),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth(),
                    contentScale = ContentScale.Crop
                )
            }
        }
    }
}

@Preview
@Composable
fun KittenCardLeftPreview() {
    KittenCard(puppies[0], Orientation.LEFT, rememberNavController())
}

@Preview
@Composable
fun KittenCardRightPreview() {
    KittenCard(puppies[0], Orientation.RIGHT, rememberNavController())
}

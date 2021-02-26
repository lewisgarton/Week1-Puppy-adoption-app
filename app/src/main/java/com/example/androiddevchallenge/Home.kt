package com.example.androiddevchallenge

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

// Start building your app here!
@Composable
fun HomeScreen(navController: NavController) {

    kittenList(puppies = puppies, navController = navController)
}

@Composable
fun kittenList(puppies: List<Kitten>, navController: NavController) {

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        var orientation = Orientation.LEFT
        items(puppies) { kitten ->
            KittenCard(kitten, orientation, navController)
            Spacer(
                modifier = Modifier
                    .height(17.dp)
                    .fillMaxWidth()
            )
            orientation = when (orientation) {
                Orientation.LEFT -> Orientation.RIGHT
                Orientation.RIGHT -> Orientation.LEFT
            }
        }
    }
}

@Composable
@Preview
fun KittenListPreview() {
    kittenList(puppies, rememberNavController())
}
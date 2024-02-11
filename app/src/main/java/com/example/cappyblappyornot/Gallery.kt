package com.example.cappyblappyornot

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.unit.dp
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview

val capybaras = listOf<Capybara>(
    Capybara("Handsome Capybara", R.drawable.handsomeblappy),
    Capybara("Serious Capybara", R.drawable.cappyblappy),
    Capybara("Deep Capybara", R.drawable.stunning_cappyblappy))

@Composable
fun GalleryS() {
    Scaffold(
        floatingActionButton = { AddButton {}}
    ) { inner ->
        LazyColumn(modifier = Modifier.padding(inner),
                horizontalAlignment = Alignment.CenterHorizontally) {
            items(count = capybaras.count()) {index ->
                Image(painterResource(id = capybaras.get(index).id), "Capybara")
                Text(text = capybaras.get(index).name)
            }
        }
    }
}

@Composable
fun AddButton(onClick: () -> Unit) {
    ExtendedFloatingActionButton(
        onClick = { onClick() },
        icon = { Icon(Icons.Filled.Add, "Extended floating action button.") },
        text = { Text(text = "Add capybara") },
    )
}

@Preview
@Composable
fun GalleryPreview() {
    GalleryS()
}
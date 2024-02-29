package com.example.cappyblappyornot

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts.*
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import android.net.Uri
import androidx.activity.result.PickVisualMediaRequest
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import coil.compose.AsyncImage

@Composable
fun GalleryS(capybaras: MutableList<Pair<String, Uri>>) {
    var selectedImageUri by remember {
        mutableStateOf<Uri?>(null)
    }
    fun addImage(uri: Uri?) {
        selectedImageUri = uri
        if (uri != null)
            capybaras.add(Pair("<placeholder>", uri))
    }
    val photoPickerLauncher = rememberLauncherForActivityResult(
        contract = PickVisualMedia(),
        onResult = { uri -> addImage(uri) })

    Scaffold(
        floatingActionButton = { AddButton {photoPickerLauncher.launch(PickVisualMediaRequest(PickVisualMedia.ImageOnly))}}
    ) { inner ->
        LazyColumn(modifier = Modifier.padding(inner),
                horizontalAlignment = Alignment.CenterHorizontally) {
            items(count = capybaras.count()) {index ->
                AsyncImage(model = capybaras[index].second, contentDescription = "Capybara")
                Text(text = capybaras[index].first)
            }
        }
    }
}

@Composable
fun AddButton(onClick: () -> Unit) {
    ExtendedFloatingActionButton(
        onClick = { onClick() },
        icon = { Icon(Icons.Filled.Add, "Click to add capybara.") },
        text = { Text(text = "Add") },
    )
}
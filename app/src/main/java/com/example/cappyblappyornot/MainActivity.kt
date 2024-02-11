package com.example.cappyblappyornot

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cappyblappyornot.ui.theme.CappyblappyOrNotTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CappyblappyOrNotTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavMenu()
                }
            }
        }
    }
}

@Composable
fun NavMenu(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    Surface(
        modifier = modifier
            .fillMaxHeight()
            .fillMaxHeight()
    ) {
        NavHost(navController = navController, startDestination = "Menu") {
            composable("Menu") { Menu(modifier = modifier,
                navToQuiz = {navController.navigate("quiz")},
                navToGallery = {navController.navigate("gallery")}) }
            composable("quiz") { Quiz() }
            composable("gallery") { GalleryS() }
        }
    }
}

@Composable
fun Menu(modifier: Modifier, navToQuiz: () -> Unit, navToGallery: () -> Unit) {
    Surface(modifier = modifier.padding(50.dp)) {
        Column {
            Text(text = "Cappyblappy or NOT!", modifier = modifier.padding(24.dp))
            Button(
                onClick = { navToQuiz() },
                modifier = modifier
                    .fillMaxWidth()
            ) { Text(text = "Quiz") }
            Button(
                onClick = { navToGallery() },
                modifier = modifier
                    .fillMaxWidth()
            ) { Text(text = "Gallery") }
        }
    }
}

@Preview
@Composable
fun MainPreview() {
    CappyblappyOrNotTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            NavMenu()
        }
    }
}
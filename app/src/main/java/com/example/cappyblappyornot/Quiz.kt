package com.example.cappyblappyornot

import android.net.Uri
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun Quiz(capybaras: MutableList<Pair<String, Uri>>) {

    val index = remember { mutableIntStateOf(0) }
    fun next() {
        if (index.intValue >= capybaras.count() - 1)
            index.intValue = -1
        else
            index.intValue++
    }

    Surface {
        if (index.intValue == -1)
            Finished()
        else {
            Column {
                QuizCard(capybara = capybaras[index.intValue])
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    onClick = { next() }) { Text(text = "Next") }
            }
        }
    }
}

@Composable
fun QuizCard(capybara: Pair<String, Uri>) {
    Surface(
        modifier = Modifier
    ) {
        Column(modifier = Modifier.padding(10.dp)) {
            AsyncImage(
                model = capybara.second,
                contentDescription = capybara.first,
                modifier = Modifier.fillMaxWidth()
            )
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = { check("", capybara.first) }) { Text(text = capybara.first) }
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = { check("", capybara.first) }) { Text(text = capybara.first) }
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = { check("", capybara.first) }) { Text(text = capybara.first) }
        }
    }
}

fun check(answer: String, correct: String): Boolean {
    return answer == correct
}

@Composable
fun Finished() {

}

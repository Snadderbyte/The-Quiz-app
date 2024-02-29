package com.example.cappyblappyornot

import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import coil.compose.AsyncImage

@Composable
fun Quiz(capybaras: MutableList<Pair<String, Uri>>) {
    var index : Int = 0
    fun next(number : Int, listSize : Int) : Int {
        if (number <= listSize)
            return -1
        return number + 1
    }

    if (index == -1)
        Finished()
    else
        QuizCard(capybara = capybaras[index], next = { index = next(index, capybaras.count()) })
}

@Composable
fun QuizCard(capybara: Pair<String, Uri>, next : () -> Unit) {
    Surface(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()) {
        Column(modifier = Modifier.padding(10.dp)) {
            AsyncImage(model = capybara.second, contentDescription = capybara.first, modifier = Modifier.fillMaxWidth())
            Button(modifier = Modifier.fillMaxWidth(), onClick = { checkAnswer("", capybara.first) }) { Text(text = capybara.first) }
            Button(modifier = Modifier.fillMaxWidth(), onClick = { checkAnswer("", capybara.first) }) { Text(text = capybara.first) }
            Button(modifier = Modifier.fillMaxWidth(), onClick = { next() }) { Text(text = "Next")}
        }
    }
}

@Composable
fun Finished() {

}
fun checkAnswer(answer: String, correct: String) : Boolean {
    return answer == correct
}


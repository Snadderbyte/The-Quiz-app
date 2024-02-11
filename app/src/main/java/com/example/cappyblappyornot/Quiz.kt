package com.example.cappyblappyornot

import androidx.compose.foundation.Image
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

@Composable
fun Quiz() {
    Surface(modifier = Modifier.fillMaxWidth()
        .fillMaxHeight()) {
        Column(modifier = Modifier.padding(10.dp)) {
            Image(painter = painterResource(id = R.drawable.handsomeblappy), contentDescription = "What a handsome cappyblappy?", Modifier.fillMaxWidth())
            Button(modifier = Modifier.fillMaxWidth(), onClick = { /*TODO*/ }) { Text(text = "Alternative 1") }
            Button(modifier = Modifier.fillMaxWidth(), onClick = { /*TODO*/ }) { Text(text = "Alternative 1") }
        }
    }
}
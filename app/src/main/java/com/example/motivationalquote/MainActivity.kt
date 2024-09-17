package com.example.motivationalquote

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.motivationalquote.ui.theme.MotivationalQuoteTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MotivationalQuoteTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MotivationalQuoteApp()
                }
            }
        }
    }
}

@Composable
fun MotivationalQuoteApp() {
    val quotes = listOf(
        "Why do we fall, sir? So that we can learn to pick ourselves up.",
        "Sometimes people deserve to have their faith rewarded.",
        "Our greatest accomplishments cannot be behind us... our destiny lies above us.",
        "There's a difference between knowing the path and walking the path.",
        "Live now; make now always the most precious time. Now will never come again."
    )

    var currentQuote by remember { mutableStateOf(quotes.random()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = currentQuote,
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        Button(
            onClick = { currentQuote = quotes.random() }
        ) {
            Text("New Motivational Quote")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MotivationalQuoteAppPreview() {
    MotivationalQuoteTheme {
        MotivationalQuoteApp()
    }
}
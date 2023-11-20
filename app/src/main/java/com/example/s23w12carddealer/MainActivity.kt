package com.example.s23w12carddealer

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import com.example.s23w12carddealer.ui.theme.S23W12CardDealerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            S23W12CardDealerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        CardImages()
                        ShuffleButton()
                    }
                }
            }
        }
    }
}

@Composable
fun CardImages() {
    if (LocalConfiguration.current.orientation == Configuration.ORIENTATION_LANDSCAPE) { // 가로인지 확인
        Text("가로")
    }
    else {
        Text("세로")
    }
}

@Composable
fun ShuffleButton() {
    Button(onClick = {}) {
        Text("Good Luck")
    }
}
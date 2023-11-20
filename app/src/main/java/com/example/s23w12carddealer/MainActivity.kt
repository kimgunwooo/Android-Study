package com.example.s23w12carddealer

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
fun ColumnScope.CardImages() { // ColumnScope 를 사용해서 onCreate의 Column을 scope 함
    if (LocalConfiguration.current.orientation
        == Configuration.ORIENTATION_LANDSCAPE) {
        // weight(1f)은 onCreate()에 있는 Column에 적용됨
        // 버튼을 맨 밑에 위치시키기 위함
        Row(modifier = Modifier.weight(1f)) {
            Text("가로")
        }
    }
    else {
        // 첫 번째 parameter가 modifier이므로 "modifier =" 안써도 됨
        Column(Modifier.weight(1f)) {
            // Row의 weight는 세로 화면에서 균등 분배
            Row(Modifier.weight(1f)) {
                Text("세로")
            }
            Row(Modifier.weight(1f)) {
                Text("세로")
            }
            Row(Modifier.weight(1f)) {
                Text("세로")
            }
        }
    }
}

@Composable
fun ShuffleButton() {
    Button(modifier = Modifier.fillMaxWidth(), onClick = {}) {
        Text("Good Luck")
    }
}
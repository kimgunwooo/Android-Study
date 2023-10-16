package kr.ac.kumoh.s20190087.s23w06intent

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat.startActivity
import kr.ac.kumoh.s20190087.s23w06intent.ui.theme.S23W06IntentTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {//activity_main.xml이라고 생각
            S23W06IntentTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

// 위젯 이나 component 라고 생각
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val context = LocalContext.current

    Column (
        modifier = modifier
    ){
        Button(
            onClick = {
                val uri = Uri.parse("https://www.youtube.com/results?search_query=android+developer")
                val intent = Intent(Intent.ACTION_VIEW,uri)
                startActivity(context,intent,null)
            },
            modifier = modifier
                .fillMaxWidth()
        ) {
            Text("유튜브 검색")
        }
        Button(
            onClick = {
                val uri = Uri.parse("https://www.instagram.com/friendshiping94/")
                val intent = Intent(Intent.ACTION_VIEW,uri)
                startActivity(context,intent,null)
            },
            modifier = modifier
                .fillMaxWidth()
        ) {
            Text("인스타그램")
        }
        Button(
            onClick = {
                val uri = Uri.parse("https://www.facebook.com/hashtag/%EC%9A%B0%EC%A0%95%EC%9E%89/")
                val intent = Intent(Intent.ACTION_VIEW,uri)
                startActivity(context,intent,null)
            },
            modifier = modifier
                .fillMaxWidth()
        ) {
            Text("페이스 북")
        }
        Button(
            onClick = {
                val uri = Uri.parse("geo:36.145014,128.393047?z=17")
                val intent = Intent(Intent.ACTION_VIEW,uri)
                startActivity(context,intent,null)
            },
            modifier = modifier
                .fillMaxWidth()
        ) {
            Text("좌표")
        }
        Button(
            onClick = {
                val uri = Uri.parse("geo:0,0?q=겅상북도 구미시 거의동 387-7")
                val intent = Intent(Intent.ACTION_VIEW,uri)
                startActivity(context,intent,null)
            },
            modifier = modifier
                .fillMaxWidth()
        ) {
            Text("우리집")
        }
        Button(
            onClick = {
                val uri = Uri.parse("tel:0544787519")
                val intent = Intent(Intent.ACTION_VIEW,uri)
                startActivity(context,intent,null)
            },
            modifier = modifier
                .fillMaxWidth()
        ) {
            Text("전화 (학과 사무실)")
        }
        Button(
            onClick = {
                val uri = Uri.parse("sms:0544787519")
                val intent = Intent(Intent.ACTION_VIEW,uri)
                intent.putExtra("sms_body", "전화 부탁드립니다.")
                startActivity(context,intent,null)
            },
            modifier = modifier
                .fillMaxWidth()
        ) {
            Text("SMS")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    S23W06IntentTheme {
        Greeting("Android")
    }
}
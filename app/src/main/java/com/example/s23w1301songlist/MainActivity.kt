package com.example.s23w1301songlist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.s23w1301songlist.ui.theme.S23W1301SongListTheme

data class Songs(var title: String, var singer: String)
private val songs = mutableListOf<Songs>()

class MainActivity : ComponentActivity() {

    private val viewModel: SongViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        repeat(10) {
            songs.add(Songs("super shy", "NewJeans"))
            songs.add(Songs("OMG", "NewJeans"))
            songs.add(Songs("소주 한 잔", "임창정"))
        }

        setContent {
            MainScreen(viewModel)
        }
    }
}

@Composable
fun MainScreen(viewModel: SongViewModel) {
    val songList by viewModel.songList.observeAsState(emptyList())

    S23W1301SongListTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            SongList(songList)
        }
    }
}

@Composable
fun SongList(songList: List<Song>) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp) // vertical = 맨 위,아래 띄움
    ) {
//        items(songList) {song ->
//            SongItem(song)
//        }
        itemsIndexed(songList) {index, song ->
            SongItem(index, song)
        }
    }
}


@Composable
fun SongItem(index: Int, song: Song) {
    var expanded by remember { mutableStateOf(false) } // 보이는 것만 State를 가지고 있음.

    Card (
        modifier = Modifier.clickable { expanded = !expanded},
        elevation = CardDefaults.cardElevation(8.dp)
    ){
        Row(
            modifier = Modifier // 순서 중요
                .fillMaxWidth()
//                .background(Color(255, 210, 210))
                .padding(8.dp)
        ){
            AsyncImage(
                model = "https://picsum.photos/300/300?random=${index}",
                contentDescription = "노래 앨범 이미지",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(100.dp)
//                .clip(CircleShape)
                    .clip(RoundedCornerShape(10))
            )
            Spacer(modifier = Modifier.width(10.dp)) // 이미지와 컬럼 사이의 간격 띄우기
            Column(
                modifier = Modifier
                    .fillMaxSize() // 사이즈가 꽉 차지 않음.
                    .height(IntrinsicSize.Min), // 주어진 높이 내에서 가능한 공간을 모두 채우는 것
                verticalArrangement = Arrangement.SpaceAround
                // SpaceBetween - 양 끝으로 설정, SpaceAround - 위, 아래 조금씩 띄움, SpaceEvenly - 모두 같은 간격으로 띄움
            ) {
                TextTitle(song.title)
                TextSinger(song.singer)
            }
        }
        AnimatedVisibility(visible = expanded) {
            song.lyrics?.let { Text(it) }
        }
    }
}

@Composable
fun TextTitle(title: String) {
    Text(title, fontSize = 30.sp)
}

@Composable
fun TextSinger(singer: String) {
    Text(singer, fontSize = 20.sp)
}


package com.example.s23w1202retrofit

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SongViewModel : ViewModel() {
    private val SERVER_URL = "https://port-0-backend-test-gj8u2llomir0io.sel5.cloudtype.app/"
    private val songApi: SongApi

    private val _songList = MutableLiveData<List<Song>>()
    val SongList: LiveData<List<Song>>
        get() = _songList

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(SERVER_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        songApi = retrofit.create(SongApi::class.java)
        fetchSong()
    }

    private fun fetchSong() {
        viewModelScope.launch {
            try {
                val response = songApi.getSongs()
                _songList.value = response
            } catch (e: Exception) {
                Log.e("fetchSong()", e.toString())
            }
        }
    }
}
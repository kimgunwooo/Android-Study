package com.example.s23w03lotto

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class LottoViewModel : ViewModel( ) {
    private var _numbers = MutableLiveData<IntArray>(IntArray(6) { 0 })
    val numbers : LiveData<IntArray>
        get() = _numbers //copy해서 넘겨줌 (getter)
    fun generate() { //setter 역할
        //_numbers 초기화
        //_numbers = IntArray(6) { 0 }
        val newNumbers = IntArray(6) { 0 }
        var num = 0
        for (i in newNumbers.indices) { //indices = 모든 인덱스 집합
//            _numbers[i] = Random.nextInt(1, 46)
            // 중복 검사
            do {
                num = Random.nextInt(1, 46)
            } while (newNumbers.contains(num))
            newNumbers[i] = num

            //Log.i("Number!!!", _numbers[i].toString())
        }

        // 정렬
        newNumbers.sort()

        //newNumbers라는 새로운 객체를 만들어서 작업을 수행.
        //이제 _numbers.value에 대입
        _numbers.value = newNumbers
    }
}
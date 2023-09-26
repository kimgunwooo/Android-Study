package com.example.s23w03lotto

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class LottoViewModel : ViewModel( ) {
    //private var _numbers = intArrayOf(0, 0, 0, 0, 0, 0)
    private var _numbers = IntArray(6) { 0 }
    val numbers
        get() = _numbers //copy해서 넘겨줌 (getter)
    fun generate() { //setter 역할
        //_numbers 초기화
        _numbers = IntArray(6) { 0 }

        var num = 0
        for (i in _numbers.indices) { //indices = 모든 인덱스 집합
//            _numbers[i] = Random.nextInt(1, 46)
            // 중복 검사
            do {
                num = Random.nextInt(1, 46)
            } while (_numbers.contains(num))
            _numbers[i] = num

            Log.i("Number!!!", _numbers[i].toString())
        }

        // 정렬
        _numbers.sort()
    }
}
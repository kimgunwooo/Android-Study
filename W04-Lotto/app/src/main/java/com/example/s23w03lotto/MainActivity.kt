package com.example.s23w03lotto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.s23w03lotto.LottoViewModel
import com.example.s23w03lotto.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var main: ActivityMainBinding
    private lateinit var model: LottoViewModel
    private lateinit var txtNum: Array<TextView?>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("Lifecycle!!!", "onCreate")

        //setContentView(R.layout.activity_main)
        main = ActivityMainBinding.inflate(layoutInflater)
        setContentView(main.root)

        txtNum = arrayOf(main.num1, main.num2, main.num3, main.num4, main.num5, main.num6)
//        txtNum[0] = main.num1
//        txtNum[1] = main.num2
//        txtNum[2] = main.num3
//        txtNum[3] = main.num4
//        txtNum[4] = main.num5
//        txtNum[5] = main.num6

        model = ViewModelProvider(this)[LottoViewModel::class.java] //::class.java 를 쓰면 java 언어에서도 동작되게 함.
        setNumbersText();

        model.numbers.observe(this, Observer { //Observer를 통해 값이 바뀌는걸 확인하고 값 넣기
            setNumbersText()
        })

        main.btnGenerate.setOnClickListener {
            model.generate() //번호를 생성하는 일만 함.
            //setNumbersText(); //값 출력
//            main.num1.text = model.numbers[0].toString()
//            main.num2.text = model.numbers[1].toString()
//            main.num3.text = model.numbers[2].toString()
//            main.num4.text = model.numbers[3].toString()
//            main.num5.text = model.numbers[4].toString()
//            main.num6.text = model.numbers[5].toString()
        }
    }

    private fun setNumbersText(){
        txtNum.forEachIndexed { index, textView -> //Index가 필요업으면 forEach만 사용
            textView?.text = model.numbers.value!![index].toString() //nullable ?붙이기, !! - 무조건 값이 있다.
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i("Lifecycle!!!", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("Lifecycle!!!", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("Lifecycle!!!", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("Lifecycle!!!", "onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("Lifecycle!!!", "onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("Lifecycle!!!", "onDestroy")
    }
}
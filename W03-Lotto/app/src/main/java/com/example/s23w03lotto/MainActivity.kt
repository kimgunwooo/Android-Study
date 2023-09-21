package com.example.s23w03lotto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.s23w03lotto.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var main : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("Lifecycle!!!", "OnCreate()")
        //setContentView(R.layout.activity_main)
        main = ActivityMainBinding.inflate(layoutInflater)
        setContentView(main.root)



        main.btnGenerate.setOnClickListener {
            main.num1.text = Random.nextInt(1,46).toString()
            main.num2.text = Random.nextInt(1,46).toString()
            main.num3.text = Random.nextInt(1,46).toString()
            main.num4.text = Random.nextInt(1,46).toString()
            main.num5.text = Random.nextInt(1,46).toString()
            main.num6.text = Random.nextInt(1,46).toString()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i("Lifecycle!!!", "OnStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.i("Lifecycle!!!", "onResume()")
    }

    override fun onStop() {
        super.onStop()
        Log.i("Lifecycle!!!", "onStop()")
    }

    override fun onPause() {
        super.onPause()
        Log.i("Lifecycle!!!", "onPause()")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("Lifecycle!!!", "onRestart()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("Lifecycle!!!", "onDestroy()")
    }
}
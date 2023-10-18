package kr.ac.kumoh.s20190087.s23w07intentdata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.ac.kumoh.s20190087.s23w07intentdata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var main : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        main = ActivityMainBinding.inflate(layoutInflater)
        setContentView(main.root)

        main.btnMountain.setOnClickListener {

        }
    }
}
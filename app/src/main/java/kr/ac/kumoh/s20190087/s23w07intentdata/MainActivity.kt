package kr.ac.kumoh.s20190087.s23w07intentdata

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kr.ac.kumoh.s20190087.s23w07intentdata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    companion object{
        const val KEY_NAME = "location"
        const val MOUNTAIN = "mountain" //const 붙이면 시작 될 때 넣어버림 (고정) readOnly는 같음
        const val SEA = "sea"
    }

    private lateinit var main : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        main = ActivityMainBinding.inflate(layoutInflater)
        setContentView(main.root)

        main.btnMountain.setOnClickListener {
            Toast.makeText(this,"산 눌림", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, ImageActivity::class.java)
            intent.putExtra(KEY_NAME,MOUNTAIN)// key에 해당하는 부분은 string 으로, HashMap 형태로 넘겨줘야 함.
            startActivity(intent)
        }
        main.btnSea.setOnClickListener {
            Toast.makeText(this,"바다 눌림", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, ImageActivity::class.java)
            intent.putExtra(KEY_NAME,SEA)
            startActivity(intent)
        }
    }
}
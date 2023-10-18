package kr.ac.kumoh.s20190087.s23w07intentdata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kr.ac.kumoh.s20190087.s23w07intentdata.databinding.ActivityImageBinding

class ImageActivity : AppCompatActivity() {

    private lateinit var main : ActivityImageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_image)
        main = ActivityImageBinding.inflate(layoutInflater)
        setContentView(main.root)

        //Log.i("ImageActivity!!!", intent.getStringExtra("location") ?: "없음")
        val res = when (intent.getStringExtra(MainActivity.KEY_NAME)){
            "mountain" -> R.drawable.mountain
            "sea" -> R.drawable.sea
            else -> R.drawable.ic_launcher_foreground
        }

        main.image.setImageResource(res)

    }
}
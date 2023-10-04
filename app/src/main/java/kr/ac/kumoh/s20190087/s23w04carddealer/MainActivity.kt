package kr.ac.kumoh.s20190087.s23w04carddealer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kr.ac.kumoh.s20190087.s23w04carddealer.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var main : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        main = ActivityMainBinding.inflate(layoutInflater)
        setContentView(main.root)

        val card = Random.nextInt(52)
        Log.i("Card!!!","card : "+getCardName(card));

        //int type 을 return 받음 - 정수, 상수를 만들어 주기 때문에
        val res = resources.getIdentifier(
            getCardName(card),
            "drawable",
            packageName
        )

        main.card1.setImageResource(res)
    }

    private fun getCardName(c: Int) : String{
        //when : switch 문이라 생각
        val shape = when (c/13){ //val 타입은 변경 불가
            0 -> "spades"
            1 -> "diamonds"
            2 -> "hearts"
            3 -> "clubs"
            else -> "error"
        }

        val number = when (c%13){
            0 -> "ace"
            in 1..9 -> (c%13 +1).toString() //in : for 문이라고 생각
            10 -> "jack"
            11 -> "queen"
            12 -> "king"
            else -> "error"
        }

        return "c_${number}_of_${shape}"
    }
}
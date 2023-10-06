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

        // TODO: 하드 코딩 없앨 것
        suffle()
        main.shffle?.setOnClickListener {
            suffle()
        }
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

        if(number.equals("jack") || number.equals("queen") || number.equals("king")){
            return "c_${number}_of_${shape}2"
        }

        return "c_${number}_of_${shape}"
    }
    private fun suffle(){
        var check : IntArray;
        for (i in 1..5) {
            val card = Random.nextInt(52)
            Log.i("Card!!!", "card $i: " + getCardName(card))

            val res = resources.getIdentifier(
                getCardName(card),
                "drawable",
                packageName
            )

            when (i) {
                1 -> main.card1.setImageResource(res)
                2 -> main.card2?.setImageResource(res)
                3 -> main.card3?.setImageResource(res)
                4 -> main.card4?.setImageResource(res)
                5 -> main.card5?.setImageResource(res)
            }
        }
    }
}
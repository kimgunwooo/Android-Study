package kr.ac.kumoh.s20190087.s23w04carddealer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kr.ac.kumoh.s20190087.s23w04carddealer.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var main : ActivityMainBinding
    private lateinit var model : CardViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        main = ActivityMainBinding.inflate(layoutInflater)
        setContentView(main.root)

        model = ViewModelProvider(this)[CardViewModel::class.java]

        model.cards.observe(this, Observer {
            val res = IntArray(5)
            for (i in it.indices){
                res[i] = resources.getIdentifier(
                    getCardName(it[i]),
                    "drawable",
                    packageName
                )
//                when (i){
//                    0 -> main.card1.setImageResource(res)
//                    1 -> main.card2?.setImageResource(res)
//                    2 -> main.card3?.setImageResource(res)
//                    3 -> main.card4?.setImageResource(res)
//                    4 -> main.card5?.setImageResource(res)
//                }
            }
            main.card1.setImageResource(res[0])
            main.card2?.setImageResource(res[1])
            main.card3?.setImageResource(res[2])
            main.card4?.setImageResource(res[3])
            main.card5?.setImageResource(res[4])
        })

        main.btnShffle.setOnClickListener {
            model.shuffle()
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

        if(number == "jack" || number == "queen" || number == "king"){
            return "c_${number}_of_${shape}2"
        }

        return "c_${number}_of_${shape}"
    }
}
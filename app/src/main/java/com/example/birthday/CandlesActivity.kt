package com.example.birthday

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView

class CandlesActivity : AppCompatActivity() {
    var age = 1
    lateinit var cake : ImageButton
    lateinit var ageText : TextView
    lateinit var candles : ImageButton
    lateinit var candlesBlownOut : ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_candles)
        val bundle : Bundle? = intent.extras

        age = intent.getIntExtra("Age", 1)
        cake = findViewById(R.id.cakeImage)
        ageText = findViewById(R.id.ageText)
        candles = findViewById(R.id.candlesImage)
        candlesBlownOut = findViewById(R.id.candlesBlownImage)

        ageText.text = age.toString()

    }//onCreate

    fun blowFlame(view : View){
        candles!!.visibility = View.INVISIBLE
        candlesBlownOut!!.visibility = View.VISIBLE

    }

}//CandlesActivity

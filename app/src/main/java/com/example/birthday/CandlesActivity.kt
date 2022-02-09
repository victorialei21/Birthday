package com.example.birthday

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class CandlesActivity : AppCompatActivity() {
    var age = 1
    lateinit var cake : ImageView
    lateinit var ageText : TextView
    lateinit var candle1 : ImageView
    lateinit var candle2 : ImageView
    lateinit var candle3 : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_candles)
        val bundle : Bundle? = intent.extras

        age = intent.getIntExtra("Age", 1)
        cake = findViewById(R.id.cakeImage)
        ageText = findViewById(R.id.ageText)
        candle1 = findViewById(R.id.candle1)
        candle2 = findViewById(R.id.candle2)
        candle3 = findViewById(R.id.candle3)

        ageText.text = age.toString()

    }//onCreate

}//CandlesActivity
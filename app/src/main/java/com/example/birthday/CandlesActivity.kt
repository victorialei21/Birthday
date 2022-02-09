package com.example.birthday

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

class CandlesActivity : AppCompatActivity() {
    var age = 1
    lateinit var cake : ImageButton
    lateinit var ageText : TextView
    lateinit var candles : ImageButton
    lateinit var candlesBlownOut : ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_candles)

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
        endgame()
    }//blowFlame

    private fun endgame () {
        AlertDialog.Builder(this)
            .setIcon(android.R.drawable.ic_dialog_alert)
            .setTitle("You blew out all the candles!")
            .setPositiveButton("  Play Again", DialogInterface.OnClickListener()
            { dialogInterface: DialogInterface?, i: Int ->
                // reset page
                this.recreate()
            })
            .setNegativeButton("Return to Main   ", DialogInterface.OnClickListener()
            { dialogInterface: DialogInterface?, i: Int ->
                // return to main menu
                startActivity(Intent(this, MainActivity::class.java))
            })
            .show()

    }//endgame

}//CandlesActivity

package com.example.birthday

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity


class GiftActivity : AppCompatActivity() {
    lateinit var text : TextView
    var presentNdx = 1
    var name = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gift)
        presentNdx = (1..9).shuffled().first()
        name = intent.getStringExtra("Name").toString()
        text = findViewById(R.id.textView4)
        //Toast.makeText(applicationContext, presentNdx.toString(), Toast.LENGTH_LONG).show()

        if (name!="") {
            text.text = "Happy birthday $name! \nWho brought you a present? \nTap your friends to find out."
        }
    } // onCreate

    fun disappear (view : View) {
        val b = view as ImageButton
        val ourId = b.resources.getResourceEntryName(b.id)
        val presentButton = "button$presentNdx"

        b.animate().alpha(0f).rotation(720f).scaleX(0.5F).scaleY(0.5F).duration = 2000

        // end game and reveal present
        if (ourId==presentButton) {
            val handler = Handler()
            handler.postDelayed(Runnable {
                b.setImageResource(R.drawable.present)
                b.animate().alpha(1f).rotation(720f).scaleX(1F).scaleY(1F).duration = 500
            }, 1500)
            handler.postDelayed(Runnable {
                endgame()
            }, 2500)
        }
    } // disappear

    private fun endgame () {
        AlertDialog.Builder(this)
            .setIcon(android.R.drawable.ic_dialog_alert)
            .setTitle("You found the present!")
            .setPositiveButton("  Play Again", DialogInterface.OnClickListener()
            {   dialogInterface: DialogInterface?, i: Int ->
                // reset page
                this.recreate()
            })
            .setNegativeButton("Return to Main   ", DialogInterface.OnClickListener()
            {   dialogInterface: DialogInterface?, i: Int ->
                // return to main menu
                startActivity(Intent(this, MainActivity::class.java))
            })
            .show()

    } // endgame

} // GiftActivity
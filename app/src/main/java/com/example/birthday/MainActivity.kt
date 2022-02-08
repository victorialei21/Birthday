package com.example.birthday

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var editTextInput: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }//onCreate

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuInflater: MenuInflater = menuInflater
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }//onCreateOptionsMenu


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val editText = EditText(this)
        when (item.itemId) {
            R.id.age -> AlertDialog.Builder(this)
                .setTitle("Enter Your Age")
                .setPositiveButton("age"){ _,_ ->
                    val editTextInput: String = editText.getText().toString()
                }
                .show()
        }
        return false
    } //end onOptionsItemSelected

    fun showGame(view : View){
        when(view.id){
            R.id.pinataButton -> intent = Intent(applicationContext, PinataActivity::class.java)
            R.id.candlesButton -> intent = Intent(applicationContext, CandlesActivity::class.java)
            R.id.giftButton -> intent = Intent(applicationContext, GiftActivity::class.java)
        }
        startActivity(intent)
    }//showGame

}//MainActivity
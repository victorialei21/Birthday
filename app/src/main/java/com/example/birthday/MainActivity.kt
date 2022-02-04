package com.example.birthday

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }//onCreate

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuInflater: MenuInflater = menuInflater
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }//onCreateOptionsMenu

    fun selectGame(view : View){

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.pinata -> intent = Intent(this, PinataActivity::class.java)
            R.id.candles -> intent = Intent(this, CandlesActivity::class.java)
            R.id.gift -> intent = Intent(this, GiftActivity::class.java)
        }
        startActivity(intent)
        return false
    } //end onOptionsItemSelected

}//MainActivity
package com.example.birthday

import android.content.DialogInterface
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
    var age = 1

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
        val customLayout : View = layoutInflater
            .inflate(R.layout.custom_alertdialog, null)

        when (item.itemId) {
            R.id.age -> AlertDialog.Builder(this)
                .setTitle("Enter Your Age")
                .setView(customLayout)
                .setPositiveButton("Confirm", DialogInterface.OnClickListener(){
                        dialogInterface: DialogInterface?, i: Int ->
                        var editText = customLayout.findViewById<EditText>(R.id.editText)
                        age = Integer.parseInt(editText.text.toString())
                        println("age: $age")
                })
                .show()
        }
        return false
    } //onOptionsItemSelected


    fun showGame(view : View){
        when(view.id){
            R.id.pinataButton -> intent = Intent(this, PinataActivity::class.java)
            R.id.candlesButton -> intent = Intent(this, CandlesActivity::class.java)
            R.id.giftButton -> intent = Intent(this, GiftActivity::class.java)
        }
        intent.putExtra("Age", age)
        startActivity(intent)
    }//showGame

}//MainActivity
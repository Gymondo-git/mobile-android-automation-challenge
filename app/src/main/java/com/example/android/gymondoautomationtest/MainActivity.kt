package com.example.android.gymondoautomationtest

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        const val USERNAME = "automation@gymondo.de"
        const val PASSWORD = "automation"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener { proceedToList() }
    }

    private fun proceedToList() {
        if (loginField.text.toString() == USERNAME && passwordField.text.toString() == PASSWORD) {
            startActivity(Intent(this, ListActivity::class.java))
        } else {
            Toast.makeText(this, "Username and/or password incorrect", Toast.LENGTH_LONG).show()
        }
    }
}

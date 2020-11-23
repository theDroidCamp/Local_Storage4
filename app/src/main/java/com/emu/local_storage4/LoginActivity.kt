package com.emu.local_storage4

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.login.*


class MainActivity : AppCompatActivity() {

    lateinit var email: EditText
    lateinit var password: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)
        email = findViewById(R.id.email)
        password = findViewById(R.id.Password)
        showData()
        findViewById<Button>(R.id.button).setOnClickListener {
            login()
        }
    }
    private fun showData(){
        val  storeData = getSharedPreferences("storeData", Context.MODE_PRIVATE )
        val userEmail = storeData.getString("email", "")
        val userPassword =storeData.getString("password", "")

        email.setText(userEmail)
        password.setText(userPassword)
    }

    private fun login() {
        if (email.text.isEmpty()) {
            email.error = "E-mail required"
            return
        }
        if (Password.text.isEmpty()) {
            Password.error = "Password required"
            return
        }
        val storeData = getSharedPreferences("storeData", Context.MODE_PRIVATE)
        val editor = storeData.edit()
        editor.putString("email", email.text.toString())
        editor.putString("password", Password.text.toString())
        editor.apply()
        Toast.makeText(this, "Saved", LENGTH_LONG).show()
    }
}
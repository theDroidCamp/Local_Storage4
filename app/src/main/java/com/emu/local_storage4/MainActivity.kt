package com.emu.local_storage4

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var editTextName: EditText
    lateinit var editTextEmail: EditText
    lateinit var editTextSchool: EditText



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextEmail = findViewById(R.id.editTextName)
        editTextEmail = findViewById(R.id.editTextEmail)
        editTextSchool = findViewById(R.id.editTextSchool)

        retrieveData()

        findViewById<Button>(R.id.buttonSave).setOnClickListener{
            saveData()
        }
    }

    private fun retrieveData(){
        val mypref = getSharedPreferences("mypref", Context.MODE_PRIVATE)

        val name = mypref.getString("name", "")
        val email = mypref.getString("email", "")
        val school = mypref.getString("school", "")

        editTextName.setText(name)
        editTextEmail.setText(email)
        editTextSchool.setText(school)
    }

    private fun saveData() {
        if(editTextName.text.isEmpty()){
            editTextName.error = "Please Enter a name"
            return
        }
        if(editTextEmail.text.isEmpty()){
            editTextEmail.error = "Please Enter an email address"
            return
        }
        if(editTextSchool.text.isEmpty()){
            editTextSchool.error = "Please Enter Name of School"
            return
        }

        val mypref = getSharedPreferences("mypref", Context.MODE_PRIVATE)

        val editor = mypref.edit()

        editor.putString("name", editTextName.text.toString())
        editor.putString("email", editTextEmail.text.toString())
        editor.putString("school", editTextSchool.text.toString())

        editor.apply()

        Toast.makeText(this, "Data Saved", Toast.LENGTH_LONG).show()

    }
}
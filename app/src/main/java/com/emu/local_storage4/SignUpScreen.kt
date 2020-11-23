package com.emu.local_storage4

import android.content.Context
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class SignUpScreen : AppCompatActivity() {
    private lateinit var name: EditText
    private lateinit var email: EditText
    private lateinit var school: EditText
    private lateinit var password: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sign_up)

        name = findViewById(R.id.name)
        email = findViewById(R.id.mail)
        school = findViewById(R.id.school)
        password = findViewById(R.id.password)

        findViewById<Button>(R.id.button).setOnClickListener {
            saveData()
        }

    }

    private fun saveData() {
        if (name.text.isEmpty()) {
            name.error = "Please enter Name."
            return
        }
        if (email.text.isEmpty()) {
            name.error = "Please enter Email."
            return
        }
        if (school.text.isEmpty()) {
            name.error = "Please enter School."
            return
        }
        if (password.text.isEmpty()) {
            name.error = "Please enter Password."
            return
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email.text.toString()).matches()) {
            email.error = "not a valid input!"
        }


        val mypref = getSharedPreferences("mypref", Context.MODE_PRIVATE)

        val editor = mypref.edit()


        editor.putString("name", name.text.toString())
        editor.putString("email", email.text.toString())
        editor.putString("school", school.text.toString())
        editor.putString("password", password.text.toString())

        editor.apply()
        val intent = Intent(this,LoginActivity::class.java)
        startActivity(intent)
        Toast.makeText(this, "Sign up Successful! Login.", Toast.LENGTH_SHORT).show()
    }
}

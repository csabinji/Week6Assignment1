package com.sabin.softuser

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity(),View.OnClickListener {

    private lateinit var txtUsername : EditText
    private lateinit var txtPassword : EditText
    private lateinit var btnLogin : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        txtUsername = findViewById(R.id.txtUsername)
        txtPassword = findViewById(R.id.txtPassword)
        btnLogin = findViewById(R.id.btnLogin)

        btnLogin.setOnClickListener(this)

    }

    fun validateInput(): Boolean {
        if(txtUsername.text.toString() == ""){
            txtUsername.error = "Please enter your Username"
            return false
        }
        if (txtPassword.text.toString() == ""){
            txtPassword.error = "Please enter your Password"
            return false
        }
        return true
    }

    override fun onClick(v: View?) {
        when(v?.id){
        R.id.btnLogin -> {
            if (validateInput()) {
                val user = txtUsername.text.toString()
                val pass = txtPassword.text.toString()

                if (user == "softwarica" && pass == "coventry") {
                    val intent = Intent(this, MainActivity::class.java)
                    Toast.makeText(this, "Login Successful !", Toast.LENGTH_SHORT).show()
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Invalid Username or Password.", Toast.LENGTH_SHORT).show()
                }
            }
        }
        }
    }
    }

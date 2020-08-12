package com.example.smackapp.Controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.smackapp.MainActivity
import com.example.smackapp.R
import com.example.smackapp.Services.AuthService
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    fun loginLoginUserClicked(view: View) {
        val email = loginEmailTxt.text.toString()
        val password = loginPassTxt.text.toString()

        AuthService.loginUser(this, email, password) { loginSucess ->
            if (loginSucess) {

                AuthService.findUserbyEmail(this) { findSucess ->
                    if (findSucess) {
                        finish()

                    }
                }
            }
        }
    }

    fun loginCreateUserClicked(view: View) {

        val createUserIntent = Intent(this, CreateUserActivity::class.java)
        startActivity(createUserIntent)



    }

}



























package com.example.smackapp.Controller

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.smackapp.R
import com.example.smackapp.Services.AuthService
import kotlinx.android.synthetic.main.activity_create_user.*
import java.util.*

class CreateUserActivity : AppCompatActivity() {


    var userAvatar = "profileDefault"
    var avatarColor = "[0.5,0.5,0.5,1]"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_user)
        createSpinner.visibility = View.INVISIBLE
    }

    /**
     * Esta funcion genera un avatar
     * de manera random en el registro
     *
     * */
    fun generateUserAvatarClicked(view: View) {
        val random = Random()
        val color = random.nextInt(2)
        val avatar = random.nextInt(28)

        userAvatar = if (color == 0) {
            "light$avatar"

        } else {
            "dark$avatar"
        }

        val resourceId = resources.getIdentifier(userAvatar, "drawable", packageName)
        createAvatarImageView.setImageResource(resourceId)

    }

    /**
     * Esta funcion genera un color
     * random en el registro
     * el "bound" es el numero que esta excluido
     *
     * */

    fun generateColorClicked(view: View) {

        val random = Random()
        val r = random.nextInt(255)
        val g = random.nextInt(255)
        val b = random.nextInt(255)

        createAvatarImageView.setBackgroundColor(Color.rgb(r, g, b))
        val savedR = r.toDouble() / 255
        val savedG = r.toDouble() / 255
        val savedB = r.toDouble() / 255

        avatarColor = "[$savedR, $savedG, $savedB, 1]"


    }

    fun createUser(view: View) {

        enableSpinner(true)
        val userName = createUsernameTxt.text.toString()
        val email = createEmailTxt.text.toString()
        val password = createPassTxt.text.toString()

        AuthService.registerUser(this, email, password) { registerSucces ->
            if (registerSucces) {
                AuthService.loginUser(this, email, password) { loginSucess ->
                    if (loginSucess) {
                        AuthService.createUser(
                            this,
                            userName,
                            email,
                            userAvatar,
                            avatarColor
                        ) { createSucess ->
                            if (createSucess) {
                                enableSpinner(false)
                                finish()

                            }
                        }
                    }
                }
            }
        }
    }

    fun errorToast(){

        Toast.makeText(this, "something went really bad", Toast.LENGTH_SHORT).show()
        enableSpinner(false)


    }


    fun enableSpinner(enable: Boolean) {
        if (enable) {
            createSpinner.visibility = View.VISIBLE
        } else {
            createSpinner.visibility = View.INVISIBLE
        }
        createCreateUserBtn.isEnabled = !enable
        createAvatarImageView.isEnabled = !enable
        createBackgroundColorBtn.isEnabled = !enable
    }
}
























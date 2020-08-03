package com.example.smackapp.Controller

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

    fun createUserClicked() {
        AuthService.registerUser(this, "jose@core.com", "123456") {complete ->

            if (complete)

                Toast.makeText(applicationContext,"this is toast message",Toast.LENGTH_SHORT).show()
        }

    }

}



























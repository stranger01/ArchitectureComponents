package com.example.smackapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.service.autofill.UserData
import android.view.Menu
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.example.smackapp.Controller.LoginActivity
import com.example.smackapp.Services.AuthService
import com.example.smackapp.Services.UserDataService
import com.example.smackapp.Utilities.BROADCAST_USER_DATA_CHANGE
import kotlinx.android.synthetic.main.nav_header_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        LocalBroadcastManager.getInstance(this).registerReceiver(
            userDataChangeReceiver,
            IntentFilter(BROADCAST_USER_DATA_CHANGE)
        )


    }

    private val userDataChangeReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            if (AuthService.isLoggedIn) {
                userNameNavHeader.text = UserDataService.name
                userEmailNavHeader.text = UserDataService.email
                val resourceId = resources.getIdentifier(
                    UserDataService.avatarName, "drawable",
                    packageName
                )
                userImageNavHeader.setImageResource(resourceId)
                loginBtnNavHeader.text = "Logout"

            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    fun loginBtnNavClicked(view: View) {

        val loginIntent = Intent(this, LoginActivity::class.java)
        startActivity(loginIntent)

    }

    fun addChannelClicked(view: View) {

    }

    fun sendMessageBtnClicked(view: View) {

    }

}
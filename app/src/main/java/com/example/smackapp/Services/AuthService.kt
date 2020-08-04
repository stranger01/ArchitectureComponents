package com.example.smackapp.Services

import android.content.Context
import android.util.Log
import com.android.volley.Response
import com.android.volley.VolleyLog
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.smackapp.Utilities.URL_LOGIN
import com.example.smackapp.Utilities.URL_REGISTER
import org.json.JSONException
import org.json.JSONObject


/**
 * Autorizathion API goes here
 *
 * */

object AuthService {

    var isLoggedIn = false
    var userEmail = ""
    var authToken = ""

    fun registerUser(
        context: Context,
        email: String,
        password: String,
        complete: (Boolean) -> Unit
    ) {


        val jsonBody = JSONObject()
        jsonBody.put("email", email)
        jsonBody.put("password", password)
        val requestBody = jsonBody.toString()

        val registerRequest =
            object : StringRequest(Method.POST, URL_REGISTER, Response.Listener { response ->
                print(response)
                complete(true)

            }, Response.ErrorListener { error ->
                Log.d("Error", "not possible to register at this time . $error")
                complete(false)


            }) {
                override fun getBodyContentType(): String {
                    return "application/json; charset=uft-8"
                }

                override fun getBody(): ByteArray {
                    return requestBody.toByteArray()
                }
            }

        Volley.newRequestQueue(context).add(registerRequest)
    }

    fun loginUser(context: Context, email: String, password: String, complete: (Boolean) -> Unit) {

        val jsonBody = JSONObject()
        jsonBody.put("email", email)
        jsonBody.put("password", password)
        val requestBody = jsonBody.toString()

        val loginRequest =
            object : JsonObjectRequest(Method.POST, URL_LOGIN, null, Response.Listener { response ->

                try {

                    userEmail = response.getString("user")
                    authToken = response.getString("token")
                    isLoggedIn = true
                    complete(true)


                } catch (e: JSONException) {
                   Log.d("JSON", "EXC:" + e.localizedMessage)
                    complete(false)
                }


            }, Response.ErrorListener { error ->

                Log.d("Error", "not possible to register at this time . $error")
                complete(false)


            }) {

                override fun getBodyContentType(): String {
                    return "application/json; charset=uft-8"
                }

                override fun getBody(): ByteArray {
                    return requestBody.toByteArray()
                }
            }

        Volley.newRequestQueue(context).add(loginRequest)
    }
}





























































































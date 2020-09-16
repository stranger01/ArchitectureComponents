package com.e.findrepo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DisplayRepoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_repo)

        val searchTerm = intent.getStringExtra("searchTerm")

        val callback = object : Callback<GithubSearchResult> {
            override fun onResponse(
                call: Call<GithubSearchResult>,
                response: Response<GithubSearchResult>
            ) {

                val searchResult = response.body()
                if (searchResult != null) {
                    for (repo in searchResult!!.items)
                        //Toast.makeText(applicationContext, "funciona $repo", Toast.LENGTH_SHORT).show()
                        println(repo)
                }
            }

            override fun onFailure(call: Call<GithubSearchResult>, t: Throwable) {

                Toast.makeText(applicationContext, "No", Toast.LENGTH_SHORT).show()
            }

        }
        val retriever = GithubRetriever()
        if (searchTerm != null) {
            retriever.getRepo(callback, searchTerm)
        }

        Toast.makeText(applicationContext, "La busqueda es $searchTerm", Toast.LENGTH_SHORT).show()
    }
}
package com.e.findrepo

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

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
                    for (repo in searchResult!!.items) {


                    }


                    val listView = findViewById<ListView>(R.id.displayReporList)
                    listView.setOnItemClickListener { adapterView, view, i, l ->
                        val selectedRepo = searchResult!!.items[i]

                        //open the URL in browser
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(selectedRepo.html_url))
                        startActivity(intent)
                        

                    }
                    val adapter = RepoAdapter(applicationContext,android.R.layout.simple_list_item_1, searchResult!!.items)
                    listView.adapter = adapter

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

class RepoAdapter(context: Context?, resource : Int, objects: List<Repo>?): ArrayAdapter<Repo>(
    context!!, resource, objects!!
){
    override fun getCount(): Int {
        return super.getCount()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflator = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val repoView = inflator.inflate(R.layout.repo_list_layout, parent ,false)

        val textView = repoView.findViewById<TextView>(R.id.projectRepo)
        val repo = getItem(position)
        textView.text = repo?.full_name

        return repoView

    }
}























package com.kareem.respositorygit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import com.kareem.respositorygit.`interface`.GitClient
import com.kareem.respositorygit.adapter.RepoAdapter
import com.kareem.respositorygit.model.GitRepo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private var listView: ListView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.list)

        val builder = Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())

        val retrofit = builder.build()
        val client = retrofit.create<GitClient>(GitClient::class.java)
        val call = client.reposUser("kareem96") //username github

        call.enqueue(object : Callback<List<GitRepo>>{
            override fun onResponse(call: Call<List<GitRepo>>, response: Response<List<GitRepo>>) {
                val repos = response.body()

                listView!!.adapter = RepoAdapter(this@MainActivity, repos!!)
            }

            override fun onFailure(call: Call<List<GitRepo>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Error ", Toast.LENGTH_SHORT).show()
            }
        })

    }
}

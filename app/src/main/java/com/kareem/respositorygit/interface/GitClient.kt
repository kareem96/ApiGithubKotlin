package com.kareem.respositorygit.`interface`

import com.kareem.respositorygit.model.GitRepo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GitClient {
    @GET("/users/{user}/repos")
    fun reposUser(@Path("user") user: String): Call<List<GitRepo>>
}
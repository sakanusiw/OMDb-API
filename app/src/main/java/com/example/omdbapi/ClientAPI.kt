package com.example.omdbapi

import com.example.omdbapi.modeldata.SearchData
import retrofit2.Call
import retrofit2.http.GET
import com.example.omdbapi.MainActivity.*
import retrofit2.http.POST
//Search Engine
interface ClientAPI {
    @GET("?s=minion&apikey=5b513a97")
    fun getMovies(): Call<SearchData>
}
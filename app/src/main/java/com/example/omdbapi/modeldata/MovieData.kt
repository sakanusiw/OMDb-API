package com.example.omdbapi.modeldata

import com.google.gson.annotations.SerializedName
import java.time.Year

class MovieData (
    val Year:String,
    val Title:String,
    @SerializedName("Poster") val gambar:String
)
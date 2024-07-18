package com.example.superhero.network

import com.example.superhero.model.Superhero
import retrofit2.Call
import retrofit2.http.GET

interface SuperheroApiService {
    @GET("api.php/8c8c75e420f100627acc44433f3c9581/659")
    fun getSuperhero(): Call<Superhero>
}
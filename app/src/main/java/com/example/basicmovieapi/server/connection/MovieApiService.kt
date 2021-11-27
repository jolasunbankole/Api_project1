package com.example.basicmovieapi.server.connection

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://movie-database-imdb-alternative.p.rapidapi.com/?r=json&i=tt4154796"



     val moshi: Moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

     val retrofit: Retrofit = Retrofit.Builder()
         .addConverterFactory(MoshiConverterFactory.create(moshi))
         .baseUrl(BASE_URL)
         .build()

interface MovieApiService {
    @GET ("?r=json&i=tt4154796")
    suspend fun getMovies() : List<MovieContentResponse>
}

object MovieApi {
    val retrofitService: MovieApiService by lazy { retrofit.create(MovieApiService::class.java) }
}





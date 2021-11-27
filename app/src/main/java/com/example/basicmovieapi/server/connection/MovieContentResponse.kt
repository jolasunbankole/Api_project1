package com.example.basicmovieapi.server.connection

import com.squareup.moshi.Json


data class MovieContentResponse(
    val Title: String,
    @Json(name = "Title") val get_title: String,

    val Year: String,
    @Json(name = "Year") val get_Year: String,

    val Rated: String ,
    @Json(name = "Rated") val get_Rated: String,

    val Released: String ,
    @Json(name = "Released") val get_Released: String,

    val Genre: String ,
    @Json(name = "Genre") val get_Genre: String,

    val imdbRating: String,
    @Json(name = "imdbRating") val get_imdbRating: String,

    val Poster: String,
    @Json(name = "Poster") val get_poster: String,




)






















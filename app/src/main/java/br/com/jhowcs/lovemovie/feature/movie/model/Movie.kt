package br.com.jhowcs.lovemovie.feature.movie.model

import com.google.gson.annotations.SerializedName

data class Movie (
        @SerializedName("poster_path") val posterPath: String,
        val adult: Boolean,
        val overview: String,
        @SerializedName("release_date") val releaseDate: String,
        val id: Long,
        @SerializedName("original_title") val originalTitle: String,
        @SerializedName("original_language") val originalLanguage: String,
        val title: String,
        @SerializedName("backdrop_path") val backdropPath: String,
        val popularity: Double,
        @SerializedName("vote_count") val voteCount: Int,
        val video: Boolean,
        @SerializedName("vote_average") val voteAverage: Double)
package br.com.jhowcs.lovemovie.feature.movie.model

import com.google.gson.annotations.SerializedName

data class MovieResults(
        val page: Int,
        val results: ArrayList<Movie>,
        @SerializedName("total_results") val totalResults: Int,
        @SerializedName("total_pages") val totalPages: Int)

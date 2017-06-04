package br.com.jhowcs.lovemovie.network.service

import br.com.jhowcs.lovemovie.feature.movie.model.MovieResults
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface MovieService {

    @GET("movie/popular")
    fun getPopularMovies(@Query("language") language: String = "pt-BR",
                         @Query("page") page: Int = 1): Call<MovieResults>

    @GET("movie/top_rated")
    fun getTopRatedMovies(@Query("language") language: String = "pt-BR",
                         @Query("page") page: Int = 1): Call<MovieResults>
}
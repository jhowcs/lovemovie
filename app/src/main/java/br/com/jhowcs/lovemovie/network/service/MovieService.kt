package br.com.jhowcs.lovemovie.network.service

import br.com.jhowcs.lovemovie.feature.movie.popular.model.PopularMovies
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface MovieService {

    @GET("movie/popular")
    fun getPopularMovies(@Query("language") language: String = "pt-BR",
                         @Query("page") page: Int = 1): Call<PopularMovies>
}
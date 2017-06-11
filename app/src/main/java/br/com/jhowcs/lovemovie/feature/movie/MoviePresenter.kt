package br.com.jhowcs.lovemovie.feature.movie

import br.com.jhowcs.lovemovie.feature.base.BaseView
import br.com.jhowcs.lovemovie.feature.movie.model.MovieResults
import br.com.jhowcs.lovemovie.network.service.MovieService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MoviePresenter constructor(view: BaseView<MovieResults>) {

    private val movieView = view

    fun loadMovies(movieService: MovieService) {
        movieService.getPopularMovies().enqueue(object : Callback<MovieResults> {
            override fun onResponse(call: Call<MovieResults>?, response: Response<MovieResults>?) {
                response?.body()?.let {
                    movieView.onLoadData(it)
                }
            }

            override fun onFailure(call: Call<MovieResults>?, t: Throwable?) {

            }
        })
    }
}
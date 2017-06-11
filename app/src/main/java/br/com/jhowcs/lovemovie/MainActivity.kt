package br.com.jhowcs.lovemovie

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import br.com.jhowcs.lovemovie.feature.base.BaseView
import br.com.jhowcs.lovemovie.feature.configuration.model.Configuration
import br.com.jhowcs.lovemovie.feature.configuration.presenter.ConfigurationPresenter
import br.com.jhowcs.lovemovie.feature.movie.MovieAdapter
import br.com.jhowcs.lovemovie.feature.movie.MoviePresenter
import br.com.jhowcs.lovemovie.feature.movie.model.MovieResults
import br.com.jhowcs.lovemovie.network.api.BaseApi
import br.com.jhowcs.lovemovie.network.api.ConfigurationApi
import br.com.jhowcs.lovemovie.network.service.MovieService

class MainActivity : AppCompatActivity(), BaseView<MovieResults> {

    val rvMoviePopular by lazy { findViewById(R.id.rvMoviePopular) as RecyclerView }
    val configPresenter = ConfigurationPresenter()
    val moviePresenter = MoviePresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadConfiguration()
    }

    private fun loadConfiguration() {
        configPresenter.loadConfiguration(object : ConfigurationPresenter.LoadConfigurationCallback {
            override fun onConfigurationLoaded(configuration: Configuration) {
                ConfigurationApi.mConfiguration = configuration
                loadMovies()
            }
        })
    }

    private fun loadMovies() {
        val retrofit = BaseApi.getInstance()
        val movieService = retrofit.create(MovieService::class.java)
        moviePresenter.loadMovies(movieService)
    }

    override fun showProgress() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideProgress() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showEmptyState() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onLoadData(data: MovieResults) {
        val adapter = MovieAdapter(data.results)
        rvMoviePopular.layoutManager = GridLayoutManager(this@MainActivity, 2)

        rvMoviePopular.adapter = adapter
    }

    override fun onError(message: String, throwable: Throwable) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

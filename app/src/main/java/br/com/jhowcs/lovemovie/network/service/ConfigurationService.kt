package br.com.jhowcs.lovemovie.network.service

import br.com.jhowcs.lovemovie.feature.configuration.model.Configuration
import retrofit2.Call
import retrofit2.http.GET

interface ConfigurationService {

    @GET("configuration")
    fun getConfiguration(): Call<Configuration>
}
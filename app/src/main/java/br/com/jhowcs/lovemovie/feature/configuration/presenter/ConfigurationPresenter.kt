package br.com.jhowcs.lovemovie.feature.configuration.presenter

import br.com.jhowcs.lovemovie.feature.configuration.model.Configuration
import br.com.jhowcs.lovemovie.network.api.BaseApi
import br.com.jhowcs.lovemovie.network.service.ConfigurationService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ConfigurationPresenter {

    interface LoadConfigurationCallback {
        fun onConfigurationLoaded(configuration: Configuration)
    }

    fun loadConfiguration(callback: LoadConfigurationCallback) {
        val retrofit = BaseApi.getInstance()
        val configurationService = retrofit.create(ConfigurationService::class.java)

        configurationService.getConfiguration().enqueue(object : Callback<Configuration> {

            override fun onResponse(call: Call<Configuration>?, response: Response<Configuration>?) {
                if (response?.body() !== null) {
                    val configuration = response.body() as Configuration
                    callback.onConfigurationLoaded(configuration)
                }
            }

            override fun onFailure(call: Call<Configuration>?, t: Throwable?) {
            }
        })
    }

}
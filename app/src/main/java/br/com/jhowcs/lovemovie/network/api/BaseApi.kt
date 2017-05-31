package br.com.jhowcs.lovemovie.network.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class BaseApi private constructor() {

    companion object {
        private var mRetrofit: Retrofit? = null
        private val mBaseUrl: String = "https://api.themoviedb.org/3/"

        fun getInstance(): Retrofit {
            if (mRetrofit === null) {
                mRetrofit = Retrofit.Builder()
                        .baseUrl(mBaseUrl)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
            }

            return mRetrofit!!
        }
    }
}

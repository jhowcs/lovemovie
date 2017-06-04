package br.com.jhowcs.lovemovie.network.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class BaseApi private constructor() {

    companion object {
        private var mRetrofit: Retrofit? = null
        private val mBaseUrl: String = "https://api.themoviedb.org/3/"
        private val mInterceptor: RequestInterceptor = RequestInterceptor()
        private val mClient: OkHttpClient = OkHttpClient
                        .Builder()
                        .addInterceptor(mInterceptor).build()

        fun getInstance(): Retrofit {
            if (mRetrofit === null) {
                mRetrofit = Retrofit.Builder()
                        .baseUrl(mBaseUrl)
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(mClient)
                        .build()
            }

            return mRetrofit!!
        }
    }
}

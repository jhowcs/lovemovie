package br.com.jhowcs.lovemovie.network.api

import br.com.jhowcs.lovemovie.BuildConfig
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class RequestInterceptor: Interceptor {

    override fun intercept(chain: Interceptor.Chain?): Response {
        val httpUrl : HttpUrl? = chain?.request()?.url()
                ?.newBuilder()
                ?.addQueryParameter("api_key", BuildConfig.API_KEY)
                ?.build()

        val newRequest : Request? = chain?.request()
                ?.newBuilder()
                ?.url(httpUrl)
                ?.build()

        return chain?.proceed(newRequest) as Response
    }
}
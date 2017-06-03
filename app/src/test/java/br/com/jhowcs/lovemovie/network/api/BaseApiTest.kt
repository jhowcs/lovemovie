package br.com.jhowcs.lovemovie.network.api

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit


class BaseApiTest {

    private var mRetrofit: Retrofit? = null

    @Before
    fun setUp() {
        mRetrofit = BaseApi.getInstance()
    }

    @Test
    fun whenCallGetInstanceShouldReturnSameInstanceEveryTime() {
        val currentInstance: Retrofit = BaseApi.getInstance()
        assertEquals(mRetrofit, currentInstance)
    }
}
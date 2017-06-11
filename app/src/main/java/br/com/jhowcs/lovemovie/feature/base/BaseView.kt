package br.com.jhowcs.lovemovie.feature.base

interface BaseView<T> {
    fun showProgress()

    fun hideProgress()

    fun showEmptyState()

    fun onLoadData(data: T)

    fun onError(message: String, throwable: Throwable)
}
package br.com.jhowcs.lovemovie.feature.configuration

import com.google.gson.annotations.SerializedName

data class Configuration(val images: Images,
                         @SerializedName("change_keys") val changeKeys: ArrayList<String>)

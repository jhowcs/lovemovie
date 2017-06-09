package br.com.jhowcs.lovemovie.feature.configuration.model

import com.google.gson.annotations.SerializedName

data class Configuration(val images: Images,
                         @SerializedName("change_keys") val changeKeys: ArrayList<String>)

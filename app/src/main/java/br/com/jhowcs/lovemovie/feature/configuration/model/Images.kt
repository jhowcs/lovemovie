package br.com.jhowcs.lovemovie.feature.configuration.model

import com.google.gson.annotations.SerializedName

data class Images(@SerializedName("base_url") val baseUrl: String,
                  @SerializedName("secure_base_url") val secureBaseUrl: String,
                  @SerializedName("backdrop_sizes") val backdropSizes: ArrayList<String>,
                  @SerializedName("logo_sizes") val logoSizes: ArrayList<String>,
                  @SerializedName("poster_sizes") val posterSizes: ArrayList<String>,
                  @SerializedName("profile_sizes") val profileSizes: ArrayList<String>,
                  @SerializedName("still_sizes") val stillSizes: ArrayList<String>)
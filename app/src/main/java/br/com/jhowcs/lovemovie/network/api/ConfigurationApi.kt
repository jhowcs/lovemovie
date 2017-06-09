package br.com.jhowcs.lovemovie.network.api

import br.com.jhowcs.lovemovie.feature.configuration.model.Configuration

class ConfigurationApi private constructor() {

    companion object {
        lateinit var mConfiguration : Configuration
    }
}

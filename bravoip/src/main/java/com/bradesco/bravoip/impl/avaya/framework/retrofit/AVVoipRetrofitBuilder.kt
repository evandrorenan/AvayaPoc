package com.bradesco.bravoip.impl.avaya.framework.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AVVoipRetrofitBuilder {
    companion object {
        fun getRetrofitInstanceForTokenAuth(path: String): Retrofit {
            return Retrofit.Builder()
                .baseUrl(path)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}
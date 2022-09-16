package com.slowmotion.makeup2app.Network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Url

//builder
object Retrofit {
    private const val BASE_URL = "https://63155021fa82b738f755190e.mockapi.io/"

    val instance: APIService by lazy {
        //penting
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(APIService::class.java)
    }
}
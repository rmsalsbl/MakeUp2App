package com.slowmotion.makeup2app.Network

import com.slowmotion.makeup2app.Model.MakeUpModel
import retrofit2.Call
import retrofit2.http.GET

interface APIService {
    @GET("/Kamuuapp")
    fun getMakeUpList(): Call<ArrayList<MakeUpModel>>
}

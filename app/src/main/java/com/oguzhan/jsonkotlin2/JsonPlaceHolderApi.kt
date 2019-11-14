package com.oguzhan.jsonkotlin2

import retrofit2.Call
import com.oguzhan.jsonkotlin2.jsonClass.Prefix
import retrofit2.http.GET

interface JsonPlaceHolderApi {

    @GET("/prefix")
    fun getPrefixes(): Call<List<Prefix>>
}
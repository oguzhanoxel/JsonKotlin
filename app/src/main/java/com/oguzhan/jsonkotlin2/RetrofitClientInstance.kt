package com.oguzhan.jsonkotlin2

import retrofit2.Retrofit

class RetrofitClientInstance{

    lateinit var retrofit : Retrofit
    val BASE_URL =""

    fun getRetrofitInstance(): Retrofit{

        return retrofit
    }

}
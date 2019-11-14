package com.oguzhan.jsonkotlin2.jsonClass

import com.google.gson.annotations.SerializedName

class EnglishWord(
    @SerializedName("shortScale")
    var shortScale: String,
    @SerializedName("longScale")
    var longScale: String? = null
)
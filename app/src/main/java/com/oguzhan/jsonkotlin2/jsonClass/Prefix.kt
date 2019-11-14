package com.oguzhan.jsonkotlin2.jsonClass

import com.google.gson.annotations.SerializedName

class Prefix(
    @SerializedName("name")
    var name: String,
    @SerializedName("symbol")
    var symbol: String,
    @SerializedName("base10")
    var base10: String,
    @SerializedName("base1000")
    var base1000: String,
    @SerializedName("decimal")
    var decimal: Double,
    @SerializedName("englishWord")
    var englishWord: EnglishWord
)
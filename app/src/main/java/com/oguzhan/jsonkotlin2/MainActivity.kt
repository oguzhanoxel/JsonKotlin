package com.oguzhan.jsonkotlin2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.google.gson.Gson
import com.google.gson.JsonArray
import com.google.gson.reflect.TypeToken
import com.oguzhan.jsonkotlin2.jsonClass.EnglishWord
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.converter.gson.GsonConverterFactory
import java.io.InputStream
import java.lang.Exception
import com.oguzhan.jsonkotlin2.jsonClass.Prefix
import retrofit2.*


class MainActivity : AppCompatActivity() {

    lateinit var arrayAdapter: ArrayAdapter<String>
    lateinit var prefixes: List<Prefix>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val gson = Gson()

        var prefixArrayList = ArrayList<Prefix>()

        val megaEnglishWord = EnglishWord("million")
        prefixArrayList.add(Prefix("mega", "M", "10^6", "1000^2", 1000000.0, megaEnglishWord))

        val kiloEnglishWord = EnglishWord("thousand")
        prefixArrayList.add(Prefix("kilo", "k", "10^3", "1000^1", 1000.0, kiloEnglishWord))

        val hectoEnglishWord = EnglishWord("hundred")
        prefixArrayList.add(Prefix("hecto", "h", "10^2", "1000^(2/3)", 100.0, hectoEnglishWord))

        val decaEnglishWord = EnglishWord("ten")
        prefixArrayList.add(Prefix("deca", "da", "10^1", "1000^(1/3)", 10.0, decaEnglishWord))

        val deciEnglishWord = EnglishWord("tenth")
        prefixArrayList.add(Prefix("deci", "d", "10^(-1)", "1000^(-1/3)", 0.1, deciEnglishWord))

        val centiEnglishWord = EnglishWord("hundredth")
        prefixArrayList.add(Prefix("centi", "c", "10^(-2)", "1000^(-2/3)", 0.01, centiEnglishWord))

        val milliEnglishWord = EnglishWord("thousandth")
        prefixArrayList.add(Prefix("milli", "m", "10^(-3)", "1000^(-1)", 0.001, milliEnglishWord))

        val microEnglishWord = EnglishWord("millionth")
        prefixArrayList.add(Prefix("micro", "μ", "10^(-6)", "1000^(-2)", 0.000001, microEnglishWord))

        val toJsonPrefixes = gson.toJson(prefixArrayList)


        //GSON

        val fromJsonPrefix = readJSONFromAsset("prefix.json")
        val listType = object : TypeToken<List<Prefix>>() {}.type
        prefixes = gson.fromJson(fromJsonPrefix, listType)
        onItemClick()
        arrayAdapter()


    }

    fun readJSONFromAsset(string: String): String? {
        var json: String?
        try {
            val inputStream: InputStream = assets.open(string)
            json = inputStream.bufferedReader().use { it.readText() }
        } catch (ex: Exception) {
            ex.printStackTrace()
            return null
        }
        return json
    }

    fun arrayAdapter() {

        var prefixesNameArrayList = ArrayList<String>()
        for (i in 0 until prefixes.size) {
            prefixesNameArrayList.add(prefixes.get(i).name)
        }

        arrayAdapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_expandable_list_item_1, prefixesNameArrayList
        )
        listView.adapter = arrayAdapter
    }

    fun onItemClick() {

        listView.onItemClickListener =
            AdapterView.OnItemClickListener { adapterView: AdapterView<*>, view1: View, i: Int, l: Long ->

                val intent = Intent(applicationContext, Main2Activity::class.java)
                intent.putExtra("name", prefixes.get(i).name)
                intent.putExtra("base10", prefixes.get(i).base10)
                intent.putExtra("base1000", prefixes.get(i).base1000)
                intent.putExtra("symbol", prefixes.get(i).symbol)
                intent.putExtra("decimal", prefixes.get(i).decimal)
                intent.putExtra(
                    "englishWord",
                    prefixes.get(i).englishWord.shortScale
                )
                startActivity(intent)
            }


    }

}

package com.oguzhan.jsonkotlin2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val intent = intent
        val name = intent.getStringExtra("name")
        val base10 = intent.getStringExtra("base10")
        val base1000 = intent.getStringExtra("base1000")
        val symbol = intent.getStringExtra("symbol")
        val decimal = intent.getDoubleExtra("decimal", 0.0)
        val englishWord = intent.getStringExtra("englishWord")

        nameTextView.setText(" Name : " + name + " ( " + symbol + " ) ")
        baseTextView.setText(" Base 10 : " + base10 + "\nBase 1000 : " + base1000)
        decimalTextView.setText(" Decimal : " + fmt(decimal))
        wordTextView.setText(" Word : " + englishWord + " ")

    }
    fun fmt(d: Double): String {
        return if (d == d.toLong().toDouble())
            String.format("%d", d.toLong())
        else
            String.format("%s", d)
    }
}

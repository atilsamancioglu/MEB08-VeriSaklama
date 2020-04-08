package com.atilsamancioglu.verisaklama

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var sharedPreferences : SharedPreferences
    var sharedPreferencesYas : Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //SharedPreferences

        sharedPreferences = this.getSharedPreferences("com.atilsamancioglu.verisaklama",
            Context.MODE_PRIVATE)


       sharedPreferencesYas = sharedPreferences.getInt("yasAnahtarKelime",-1)

        if (sharedPreferencesYas != -1) {
            textView.text = "Yaş: ${sharedPreferencesYas}"
        } else {
            textView.text = "Yaş: "
        }


    }

    fun sil(view: View) {

        sharedPreferencesYas = sharedPreferences.getInt("yasAnahtarKelime",-1)

        if(sharedPreferencesYas != -1) {
            textView.text = "Yaş: "
            sharedPreferences.edit().remove("yasAnahtarKelime").apply()
        }


    }

    fun kaydet(view: View){



        val yas = editText.text.toString().toIntOrNull()

        if (yas != null) {
            textView.text = "Yaş: ${yas}"
            sharedPreferences.edit().putInt("yasAnahtarKelime",yas).apply()
        }


    }
}
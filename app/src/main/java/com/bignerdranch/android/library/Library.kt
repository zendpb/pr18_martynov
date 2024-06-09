package com.bignerdranch.android.library

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Library : AppCompatActivity() {
    lateinit var adapter: ArrayAdapter<String>
    lateinit var spin: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_library)

        val items = listOf<String>(
            "Толстой «Война и мир»",
            "Гончаров «Обломов»",
            "Лермонтов «Герой нашего времени»",
            "Достоевский «Преступление и наказание»"
        )
         spin = findViewById(R.id.sp)
         adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, items)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spin.adapter = adapter

    }

    fun next(view: View) {
        val selectedItem = spin.selectedItem.toString()
        val dataToJson = Book(selectedItem)
    val json = Gson().toJson(dataToJson)
    val intent = Intent(this,Results::class.java)
    intent.putExtra("title",json)
    startActivity(intent)
    }






}

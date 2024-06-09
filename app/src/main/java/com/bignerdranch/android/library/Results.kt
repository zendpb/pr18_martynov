package com.bignerdranch.android.library


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Results : AppCompatActivity() {

    private lateinit var textView: TextView

    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_results)
        textView = findViewById(R.id.textview2)

        val title = intent.getStringExtra("title")
        val fromjson = Gson().fromJson<Book>(title,object : TypeToken<Book>() {}.type)

        textView.text = "Вы выбрали : \n${fromjson.title} "
    }


    fun back(view: View) {
        val intent = Intent(this,Library::class.java)
        startActivity(intent)
    }



}
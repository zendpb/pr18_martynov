package com.bignerdranch.android.library

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.AdapterView
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {

    private lateinit var login:EditText
    private  lateinit var pass:EditText
    private lateinit var pref:SharedPreferences


    private lateinit var  builder:AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        login = findViewById(R.id.login);
        pass = findViewById(R.id.pass);

        pref = getPreferences(MODE_PRIVATE)
        val ed = pref.edit()
        ed.putString("login", intent.getStringExtra("login"))
        ed.putString("password", intent.getStringExtra("password"))
        ed.apply()



    }

    fun handler(v: View) {
        pref=getPreferences(MODE_PRIVATE)
        if (!(pref.getString("login","") == "" && pref.getString("password","") == ""))
        {
            login.setText(pref.getString("login",""))
            pass.setText(pref.getString("password",""))
            val alert = AlertDialog.Builder(this)
                .setTitle("Успешно")
                .setMessage("Сохранненые данные при регистрации загружены.")
                .setPositiveButton("Продолжить",null)
                .create()
                .show()
        }
        else
        {
            val alert = AlertDialog.Builder(this)
                .setTitle("Неверно")
                .setMessage("Данные при регистрации не обнаружены")
                .setPositiveButton("Продолжить",null)
                .create()
                .show()
        }



    }


    fun next(view: View) {
        if (login.text.toString().isNotEmpty() && pass.text.toString().isNotEmpty())
        {
            val intent = Intent(this,Library::class.java)
            startActivity(intent)
        }
        else
        {
            val alert = AlertDialog.Builder(this)
                .setTitle("Ошибка")
                .setMessage("Введите логин или пароль")
                .setPositiveButton("Продолжить",null)
                .create()
                .show()

        }


    }


    fun register(view: View) {
            val intent= Intent(this,Register::class.java)
            startActivity(intent)


    }


}
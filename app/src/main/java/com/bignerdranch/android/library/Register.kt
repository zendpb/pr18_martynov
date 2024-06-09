package com.bignerdranch.android.library

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AlertDialog

class Register : AppCompatActivity() {

    private lateinit var login: EditText
    private lateinit var pass: EditText
    private lateinit var confpass: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        login=findViewById(R.id.login)
        pass=findViewById(R.id.pass)
        confpass=findViewById(R.id.pass2)
    }


    fun reg(view: View){

        if (login.text.toString().isNotEmpty() && pass.text.toString().isNotEmpty() && confpass.text.toString().isNotEmpty())
        {
        if (pass.text.toString().length>=8 && confpass.text.toString().length >=8){
            if (pass.text.toString() == confpass.text.toString()){
                val intent = Intent(this,MainActivity2::class.java)
                intent.putExtra("login",login.text.toString())
                intent.putExtra("password",pass.text.toString())
                startActivity(intent)
            }else {
                val alert = AlertDialog.Builder(this)
                    .setTitle("неверно")
                    .setMessage("Пароли не совпадают")
                    .setPositiveButton("Исправить",null)
                    .create()
                    .show()
            }
        }else {
            val alert = AlertDialog.Builder(this)
                .setTitle("неверно")
                .setMessage("Пароль должен быть > 8 символов")
                .setPositiveButton("Исправить",null)
                .create()
                .show()
        }
        }
        else
        {
            val alert = AlertDialog.Builder(this)
                .setTitle("Ошибка")
                .setMessage("Введите логин или пароль")
                .setPositiveButton("Исправить",null)
                .create()
                .show()

        }
    }

}
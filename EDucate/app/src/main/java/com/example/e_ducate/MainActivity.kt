package com.example.e_ducate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun irTelaLogin(v: View){
        startActivity(Intent(this, Login::class.java))
    }


    fun irTelaCadastro(v: View){
        startActivity(Intent(this, CadastroUsuario::class.java))
    }


}
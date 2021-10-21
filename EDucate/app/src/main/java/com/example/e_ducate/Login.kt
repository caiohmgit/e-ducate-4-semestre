package com.example.e_ducate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlin.system.exitProcess

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    fun cadastro(v: View){
        startActivity(Intent(this, CadastroUsuario::class.java))
    }

    fun irTelaCadastroBiblio(v: View){
        startActivity(Intent(this, CadastroBiblio1::class.java))
    }

    fun fechar(v: View){
        exitProcess(0)
    }

    fun senha(v: View){
        startActivity(Intent(this, RecuperarSenha::class.java))
    }

}
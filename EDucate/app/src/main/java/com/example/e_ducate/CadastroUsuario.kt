package com.example.e_ducate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlin.system.exitProcess

class CadastroUsuario : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_usuario)
    }

    fun fechar(v: View){
        exitProcess(0)
    }

    fun alerta(v:View){
        Toast.makeText(applicationContext, "Tela em desenvolvimento", Toast.LENGTH_SHORT).show()


        startActivity(Intent(this, Login::class.java))

    }

}
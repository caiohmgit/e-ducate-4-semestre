package com.example.e_ducate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlin.system.exitProcess

class CadastroBiblio2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_biblio2)
    }

    fun irTelaCadastro3(v: View) {

        startActivity(Intent(this,CadastroBiblio3::class.java))
    }

    fun fechar(v: View) {
        exitProcess(0)
    }
}
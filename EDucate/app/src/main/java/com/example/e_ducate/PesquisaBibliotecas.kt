package com.example.e_ducate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlin.system.exitProcess

class PesquisaBibliotecas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pesquisa_bibliotecas)
    }

    fun fechar(v: View){
        exitProcess(0)
    }

}
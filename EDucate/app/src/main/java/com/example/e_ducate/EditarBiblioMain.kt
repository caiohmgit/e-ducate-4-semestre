package com.example.e_ducate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlin.system.exitProcess

class EditarBiblioMain : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editar_biblio_main)
    }

    fun fechar(v: View){
        exitProcess(0)
    }


    fun irTelaEditarInforBasicas(v: View){
        startActivity(Intent(this, EditarInforBasicasBiblio::class.java))
    }

    fun irTelaEditarEnderecoBiblio(v: View){
        startActivity(Intent(this, EditarEnderecoBiblio::class.java))
    }
}
package com.example.e_ducate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlin.system.exitProcess

class EditarPerfil : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editar_perfil)
    }


    fun fechar(v: View){
        exitProcess(0)
    }


    fun irTelaPrincipalBiblio(v: View){
        startActivity(Intent(this, VisualizacaoCoreBiblioADM::class.java))
    }

}
package com.example.e_ducate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class VisualizacaoCoreBiblioADM : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_visualizacao_core_biblio_adm)
    }


    fun irTelaEditarBiblio(v: View){
        startActivity(Intent(this, EditarBiblioMain::class.java))
    }

    fun irTelaContato(v: View){
        startActivity(Intent(this, Contato::class.java))
    }

    fun irTelaAdicionarLivro(v: View){
        startActivity(Intent(this, AdicionarLivro::class.java))
    }

    fun irTelaMeuPerfil(v: View){
        startActivity(Intent(this, MeuPerfil::class.java))
    }

}

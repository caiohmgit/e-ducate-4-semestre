package com.example.e_ducate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MenuPrincipalUsuario : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_principal_usuario)
    }

    fun irTelaPesquisa(v: View){
        startActivity(Intent(this, PesquisaBibliotecas::class.java))
    }


}
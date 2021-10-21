package com.example.e_ducate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class CadastroBiblio1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_biblio1)
    }


    fun irTelaCadastro2(v: View) {

        startActivity(Intent(this,CadastroBiblio2::class.java))
    }

}
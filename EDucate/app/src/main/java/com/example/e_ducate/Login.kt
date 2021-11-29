package com.example.e_ducate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
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

    fun irTelaPrincipalUsuario(v: View){
        startActivity(Intent(this, MenuBar::class.java))
    }

    fun irTelaPrincipalADM(v: View){
        startActivity(Intent(this, MenuBarAdm::class.java))
    }

    fun irTelaPrincipal(v:View) {
        val etUsuario : EditText = findViewById(R.id.editTextTextEmailAddress)
        val usuario:String = etUsuario.text.toString()
        if (usuario == "1") {
            finish()
            startActivity(Intent(this, CadastroBiblio1::class.java))
        } else {
            finish()
            startActivity(Intent(this, MenuBar::class.java))
        }

    }

    fun fechar(v: View){
        exitProcess(0)
    }

    fun senha(v: View){
        startActivity(Intent(this, RecuperarSenha::class.java))
    }

}
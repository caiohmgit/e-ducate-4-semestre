package com.example.e_ducate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.example.acessoeducateuser.models.SignInBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import kotlin.math.log
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
        val emailtxt: EditText =findViewById(R.id.editTextTextEmailAddress)
        val senhatxt: EditText = findViewById(R.id.editTextTextPassword)

        signin(emailtxt.text.toString(),senhatxt.text.toString())

        finish()
        startActivity(Intent(this, MenuBar::class.java))
    }

    fun fechar(v: View){
        exitProcess(0)
    }

    fun senha(v: View){
        startActivity(Intent(this, RecuperarSenha::class.java))
    }
    private fun signin(email: String, password: String){

        val retIn = ClientRest.criarClientBiblioteca()!!
        val signInInfo = SignInBody(email, password)
        retIn.signin(signInInfo).enqueue(object : retrofit2.Callback<ResponseBody> {
            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Toast.makeText(applicationContext, t.message, Toast.LENGTH_SHORT).show()
            }
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if (response.code() == 200) {
                 
                    Toast.makeText(applicationContext, "Login success!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(applicationContext, "Login failed!", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }
}
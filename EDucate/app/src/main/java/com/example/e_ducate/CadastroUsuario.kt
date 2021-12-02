package com.example.e_ducate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.example.acessoeducateuser.models.UserBody
import okhttp3.ResponseBody
import retrofit2.Response
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
        val nometxt: EditText =findViewById(R.id.editTextNomeCadastro)
        val emailtxt: EditText =findViewById(R.id.editTextEmailCadastro)
        val senhatxt: EditText = findViewById(R.id.editTextTextPasswordCadastro)
        val telefonetxt: EditText =findViewById(R.id.editTextTelefonetCadastro)

        signup(nometxt.text.toString(),emailtxt.text.toString(),senhatxt.text.toString(),telefonetxt.text.toString())


        startActivity(Intent(this, Login::class.java))

    }
    private fun signup(nome: String, email: String, senha: String,
                       telefone: String){
        val retIn = ClientRest.criarClientBiblioteca()!!
        val registerInfo = UserBody(nome,email,senha,telefone)

        retIn.registerUser(registerInfo).enqueue(object :
            retrofit2.Callback<ResponseBody> {
            override fun onFailure(call: retrofit2.Call<ResponseBody>, t: Throwable) {
                Toast.makeText(
                    applicationContext,
                    t.message,
                    Toast.LENGTH_SHORT
                ).show()
            }
            override  fun onResponse(call: retrofit2.Call<ResponseBody>, response: Response<ResponseBody>) {
                if (response.code() == 201) {
                    Toast.makeText(applicationContext, "Registration success!", Toast.LENGTH_SHORT)
                        .show()

                }
                else{
                    Toast.makeText(applicationContext, "Registration failed!", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        })
    }

}
package com.example.e_ducate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MenuPrincipalUsuario : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_principal_usuario)

        val resultadoBusca: LinearLayout = findViewById(R.id.ll_bibliotecas_recomendadas)
        resultadoBusca.removeAllViews()

        val clientAPIBiblioteca = ClientRest.criarClientBiblioteca()

        clientAPIBiblioteca?.getBibliotecas()?.enqueue(object : Callback<List<Biblioteca>> {
            override fun onResponse(
                call: Call<List<Biblioteca>>,
                response: Response<List<Biblioteca>>
            ) {
                if (response.isSuccessful) {
                    val transaction = supportFragmentManager.beginTransaction()
                    response.body()?.forEach {

                        val params = Bundle()
                        params.putSerializable("biblioteca", it)


                        val fragment = BibliotecaPesquisaFragment()

                        fragment.arguments = params
                        transaction.add(R.id.ll_bibliotecas_recomendadas, fragment)

                    }

                    transaction.commit()
                }
            }

            override fun onFailure(call: Call<List<Biblioteca>>, t: Throwable) {
                Log.e("API Biblioteca", t.message!!)
                Toast.makeText(baseContext, "Erro na chamada da API", Toast.LENGTH_SHORT).show()
            }

        })


    }

    fun irTelaPesquisa(v: View){
        startActivity(Intent(this, PesquisaBibliotecas::class.java))
    }


}
package com.example.e_ducate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.system.exitProcess

class PesquisaBibliotecas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pesquisa_bibliotecas)


        val resultadoBusca:LinearLayout = findViewById(R.id.ll_resultado_busca_bibliotecas)
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
                        transaction.add(R.id.ll_resultado_busca_bibliotecas, fragment)

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

    fun fechar(v: View){
        exitProcess(0)
    }

}
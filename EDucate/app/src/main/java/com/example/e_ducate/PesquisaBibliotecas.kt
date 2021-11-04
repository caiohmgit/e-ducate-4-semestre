package com.example.e_ducate

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import com.squareup.picasso.Picasso
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


                        val fragment = BibliotecaFragment()

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


//        val dados = listOf(
//            mapOf(Pair("N","Biblioteca da BandTec"), Pair("E","Rua Haddock Lobo")),
//            mapOf(Pair("N","Biblioteca da afads"), Pair("E","Rua Haddock vsdfsdfe")),
//            mapOf(Pair("N","Biblioteca da BanasdasdTec"), Pair("E","Rua Haddock gsdfsf")),
//            mapOf(Pair("N","Biblioteca da BandTasdaec"), Pair("E","Rua Haddock sdfsdf")),
//            mapOf(Pair("N","Biblioteca da asdasda"), Pair("E","Rua Haddock sdfAD")),
//            mapOf(Pair("N","Biblioteca da fgsdfsf"), Pair("E","Rua Haddock sagdgs"))
//        )





//        dados.forEach {
//            val params = Bundle()
//            params.putString("nome", it["N"])
//            params.putString("endereco", it["E"])
//
//            val fragment = BibliotecaFragment()
//
//            fragment.arguments = params
//            transaction.add(R.id.ll_resultado_busca_bibliotecas, fragment)
//
//        }





    }

    fun fechar(v: View){
        exitProcess(0)
    }

}
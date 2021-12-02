package com.example.e_ducate

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ClientRest {

    fun criarClientBiblioteca(): ClientAPIBiblioteca? {
        return Retrofit.Builder()
            .baseUrl("http://34.235.67.122/sistema/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ClientAPIBiblioteca::class.java)
    }

}
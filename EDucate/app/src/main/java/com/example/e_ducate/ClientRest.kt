package com.example.e_ducate

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ClientRest {

    fun criarClientBiblioteca(): ClientAPIBiblioteca? {
        return Retrofit.Builder()
            .baseUrl("https://61831ab891d76c00172d177f.mockapi.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ClientAPIBiblioteca::class.java)
    }

}
package com.example.e_ducate

import retrofit2.Call
import retrofit2.http.GET

interface ClientAPIBiblioteca {

    @GET("/bibliotecas")
    fun getBibliotecas(): Call<List<Biblioteca>>
}
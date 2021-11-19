package com.example.e_ducate

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ClientAPIBiblioteca {

    @GET("/biblio/bibliotecas")
    fun getBibliotecas(): Call<List<Biblioteca>>

    @GET("/livros/{id}")
    fun getLivrosDaBiblioteca(@Path("id") id:Int): Call<List<Livro>>

    @GET("/biblio/biblioteca/{id}")
    fun getBiblioteca(@Path("id") id:Int): Call<Biblioteca>

    @GET("/user/usuario/{id}")
    fun getUsuario(@Path("id") id:Int): Call<Usuario>

}
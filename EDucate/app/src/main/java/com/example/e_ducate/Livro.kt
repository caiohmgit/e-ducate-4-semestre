package com.example.e_ducate

import java.io.Serializable

data class Livro(
    val id:Int,
    val nome:String,
    val autor:String,
    val genero:String,
    val urlCapaLivro:String,
    val biblioteca:Biblioteca
                ):Serializable {
}
package com.example.e_ducate

import com.example.acessoeducateuser.models.SignInBody
import com.example.acessoeducateuser.models.UserBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface ClientAPIBiblioteca {

    @GET("biblio/bibliotecas")
    fun getBibliotecas(): Call<List<Biblioteca>>

    @GET("biblio/bibliotecas/buscar/{nome}")
    fun getBibliotecasPesquisa(@Path("nome") nome:String): Call<List<Biblioteca>>

    @GET("livros/{id}")
    fun getLivrosDaBiblioteca(@Path("id") id:Int): Call<List<Livro>>

    @GET("biblio/biblioteca/{id}")
    fun getBiblioteca(@Path("id") id:Int): Call<Biblioteca>

    @GET("user/usuario/{id}")
    fun getUsuario(@Path("id") id:Int): Call<Usuario>

    @POST("asasas")
    fun postBiblioteca(@Body biblioteca: Biblioteca): Call<Void>

    @POST("contato/{id}")
    fun postContato(@Path("id") id: Int) : Call<Contato>

    // Acesso usuario
    @Headers("Content-Type:application/json")
    @POST("/sistema/sessao/login")
    fun signin(@Body info: SignInBody): retrofit2.Call<ResponseBody>

    @Headers("Content-Type:application/json")
    @POST("/sistema/user/usuario")
    fun registerUser(
        @Body info: UserBody
    ): retrofit2.Call<ResponseBody>

    // contato
//    @Headers("Content-Type:application/json")
//    @POST("/sistema/contato/1")
//    fun registerCtt(
//        @Body info: UserBody
//    ): retrofit2.Call<ResponseBody>

}
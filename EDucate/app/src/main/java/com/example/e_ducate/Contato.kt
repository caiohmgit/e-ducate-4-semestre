package com.example.e_ducate

import java.io.Serializable

data class Contato (val id:Int,
                      val firstName:String,
                      val lastName:String,
                      val email:String,
                      val nroCelular:String,
                      val mensagem:String,
                      val remetente:Usuario): Serializable

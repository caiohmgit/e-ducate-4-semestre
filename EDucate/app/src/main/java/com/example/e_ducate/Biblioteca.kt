package com.example.e_ducate

import java.io.Serializable

data class Biblioteca(val id:Int,
                      val nome:String,
                      val descricao:String,
                      val horarioFunc:String,
                      val nota:Double?,
                      val localizacao: Localizacao,
                      val homeOffice:Boolean,
                      val urlBiblio:String?,
                      val fkUsuarioAdm:Usuario):Serializable



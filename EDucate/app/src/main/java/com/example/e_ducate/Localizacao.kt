package com.example.e_ducate

import java.io.Serializable

data class Localizacao(val nomeRua:String,
                       val bairro:String,
                       val cidade:String,
                       val estado:String,
                       val cep:String):Serializable {
}
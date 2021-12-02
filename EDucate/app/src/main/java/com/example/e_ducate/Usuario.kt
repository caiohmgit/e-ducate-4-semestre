package com.example.e_ducate

import java.io.Serializable

data class Usuario(
                    val id:Int,
                    var nome:String,
                   var email:String,
                   val senha:String,
                   var telefone:String,
                   val isADM:Boolean,
                   var urlPerfil:String?
                    ):Serializable {
}
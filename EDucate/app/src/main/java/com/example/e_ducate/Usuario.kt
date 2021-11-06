package com.example.e_ducate

import java.io.Serializable

data class Usuario(val nome:String,
                   val email:String,
                   val senha:String,
                   val telefone:String,
                   val isADM:Boolean,
                   val urlPerfil:String?
                    ):Serializable {
}
package com.example.e_ducate

import java.io.Serializable

data class UsuarioSimples(val id:Int,
                     var nome:String,
                     var email:String,
                     val senha:String,
                     var telefone:String,
                    ):Serializable




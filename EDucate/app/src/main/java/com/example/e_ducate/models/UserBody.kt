package com.example.acessoeducateuser.models

import com.google.gson.annotations.SerializedName

data class UserBody(
                    @SerializedName("nome")
                    val nome: String,
                    @SerializedName("email")
                    val email: String,
                    @SerializedName("senha")
                    val senha: String,
                    @SerializedName("telefone")
                    val telefone: String)

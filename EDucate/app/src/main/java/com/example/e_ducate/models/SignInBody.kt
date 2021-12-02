package com.example.acessoeducateuser.models

import com.google.gson.annotations.SerializedName

data class SignInBody(

    val email: String,
    val senha: String)

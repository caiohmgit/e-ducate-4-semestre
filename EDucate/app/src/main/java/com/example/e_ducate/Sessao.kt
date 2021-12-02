package com.example.e_ducate

import java.io.Serializable
import java.time.LocalDateTime

data class Sessao(val usuario:UsuarioSimples,
                 val inicioDaSessao:String,
                 val fimDaSessao:String,
                 val isLoggedIn: Boolean ):Serializable

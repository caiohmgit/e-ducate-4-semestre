package com.example.e_ducate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlin.system.exitProcess

class CadastroBiblio3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_biblio3)
    }

    //    Primeira linha se seleção

    fun acessoInternet(v: View) {
        val btn_acesso_internet : Button = findViewById(R.id.btn_acesso_internet)

        btn_acesso_internet.isSelected = !btn_acesso_internet.isSelected
    }

    fun espacoEstudo(v: View) {
        val btn_espacos_estudo : Button = findViewById(R.id.btn_espacos_estudo)

        btn_espacos_estudo.isSelected = !btn_espacos_estudo.isSelected
    }

    fun livrosCientificos(v: View) {
        val btn_livros_cientificos : Button = findViewById(R.id.btn_livros_cientificos)

        btn_livros_cientificos.isSelected = !btn_livros_cientificos.isSelected
    }

//    Segunda linha de seleção

    fun computadoresDisponiveis(v: View) {
        val btn_comput_disponiveis : Button = findViewById(R.id.btn_comput_disponiveis)

        btn_comput_disponiveis.isSelected = !btn_comput_disponiveis.isSelected
    }

    fun variedadeLivros(v: View) {
        val btn_variedade_livros : Button = findViewById(R.id.btn_variedade_livros)

        btn_variedade_livros.isSelected = !btn_variedade_livros.isSelected
    }

    fun espacoSilencioso(v: View) {
        val btn_espaco_silencioso : Button = findViewById(R.id.btn_espaco_silencioso)

        btn_espaco_silencioso.isSelected = !btn_espaco_silencioso.isSelected
    }

//    Terceira linha de seleção

    fun espacoTrabalho(v: View) {
        val btn_workspace : Button = findViewById(R.id.btn_workspace)

        btn_workspace.isSelected = !btn_workspace.isSelected
    }

    fun eventosCulturais(v: View) {
        val btn_eventos_culturais : Button = findViewById(R.id.btn_eventos_culturais)

        btn_eventos_culturais.isSelected = !btn_eventos_culturais.isSelected
    }

    fun aluguelLivros(v: View) {
        val btn_aluguel_livros : Button = findViewById(R.id.btn_aluguel_livros)

        btn_aluguel_livros.isSelected = !btn_aluguel_livros.isSelected
    }

//    Quarta linha de seleção

    fun espacoArLivre(v: View) {
        val btn_espaco_ar_livre : Button = findViewById(R.id.btn_espaco_ar_livre)

        btn_espaco_ar_livre.isSelected = !btn_espaco_ar_livre.isSelected
    }

    fun livrosInfantis(v: View) {
        val btn_livros_infantis : Button = findViewById(R.id.btn_livros_infantis)

        btn_livros_infantis.isSelected = !btn_livros_infantis.isSelected
    }

    fun compraLivros(v: View) {
        val btn_compra_livros : Button = findViewById(R.id.btn_compra_livros)

        btn_compra_livros.isSelected = !btn_compra_livros.isSelected
    }


    fun irTelaCadastro4(v: View) {

        startActivity(Intent(this,CadastroBiblio4::class.java))
    }

    fun fechar(v: View){
        exitProcess(0)
    }

}
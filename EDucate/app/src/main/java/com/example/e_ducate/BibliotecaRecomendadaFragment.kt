package com.example.e_ducate

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.squareup.picasso.Picasso


class BibliotecaRecomendadaFragment : Fragment() {

    lateinit var flBibliotecaRecomendada : FrameLayout


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_biblioteca_recomendada, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val biblioteca:Biblioteca = arguments?.getSerializable("biblioteca") as Biblioteca

        flBibliotecaRecomendada = view.findViewById(R.id.fl_biblioteca_recomendada)
        flBibliotecaRecomendada.setOnClickListener {
            val argumentos = Bundle()
            argumentos.putSerializable("biblioteca", biblioteca)
            findNavController().navigate(R.id.library_visualization, argumentos)
        }


        val nomeBiblioteca: TextView = view.findViewById(R.id.nome_biblioteca)
        val enderecoBiblioteca: TextView = view.findViewById(R.id.endereco_biblioteca)
        val notaBiblioteca: TextView = view.findViewById(R.id.nota_biblioteca)
        val horarioFuncBiblioteca: TextView = view.findViewById(R.id.horario_func_biblioteca)
        val homeOfficeBiblioteca: TextView = view.findViewById(R.id.home_office_biblioteca)
        val imgBiblioteca: ImageView = view.findViewById(R.id.img_biblioteca)


        nomeBiblioteca.text = biblioteca.nome
        enderecoBiblioteca.text = biblioteca.localizacao.nomeRua

        if (biblioteca.nota != null) {
            notaBiblioteca.text = biblioteca.nota.toString()
        } else {
            notaBiblioteca.text = "---"
        }

        if (biblioteca.urlBiblio != null) {
            if (biblioteca.urlBiblio.contains("https")) {
                Picasso.with(view.context).load(biblioteca.urlBiblio).into(imgBiblioteca)
            } else {
                Picasso.with(view.context).load(biblioteca.urlBiblio?.replace("http", "https")).into(imgBiblioteca);
            }
        } else {
            Picasso.with(view.context).load("https://www.colunaitalo.com.br/upload/noticias/2243/capa_destaque_2_view.jpg").into(imgBiblioteca);
        }

        if (biblioteca.homeOffice) {
            homeOfficeBiblioteca.text = getString(R.string.sim)
        } else {
            homeOfficeBiblioteca.text = getString(R.string.nao)
        }

        horarioFuncBiblioteca.text = biblioteca.horarioFunc

    }


}
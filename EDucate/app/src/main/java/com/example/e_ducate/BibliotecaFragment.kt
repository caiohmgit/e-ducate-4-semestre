package com.example.e_ducate

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso


class BibliotecaFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_biblioteca, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val biblioteca:Biblioteca = arguments?.getSerializable("biblioteca") as Biblioteca

        val nomeBiblioteca:TextView = view.findViewById(R.id.nome_biblioteca)
        val enderecoBiblioteca:TextView = view.findViewById(R.id.endereco_biblioteca)
        val imgBiblioteca:ImageView = view.findViewById(R.id.img_biblioteca)


        nomeBiblioteca.text = biblioteca.nome
        enderecoBiblioteca.text = biblioteca.endereco
        Picasso.with(view.context).load(biblioteca.urlImage.replace("http", "https")).into(imgBiblioteca);
    }


}
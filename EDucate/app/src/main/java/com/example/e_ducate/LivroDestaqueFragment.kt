package com.example.e_ducate

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.squareup.picasso.Picasso


class LivroDestaqueFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_livro_destaque, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val livro:Livro = arguments?.getSerializable("livro") as Livro



        val nomeLivro: TextView = view.findViewById(R.id.nome_livro)
        val autorLivro: TextView = view.findViewById(R.id.autor_livro)
        val imgLivro: ImageView = view.findViewById(R.id.img_livro)


        nomeLivro.text = livro.nome
        autorLivro.text = livro.autor

        if (livro.urlCapaLivro != null) {
            if (livro.urlCapaLivro.contains("https")) {
                Picasso.with(view.context).load(livro.urlCapaLivro).into(imgLivro)
            } else {
                Picasso.with(view.context).load(livro.urlCapaLivro?.replace("http", "https")).into(imgLivro);
            }
        } else {
            Picasso.with(view.context).load("https://www.colunaitalo.com.br/upload/noticias/2243/capa_destaque_2_view.jpg").into(imgLivro);
        }


    }


}
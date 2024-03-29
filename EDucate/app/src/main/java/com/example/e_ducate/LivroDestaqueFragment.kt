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


class LivroDestaqueFragment : Fragment() {

    lateinit var flLivroDestaque : FrameLayout

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
        val biblioteca:Biblioteca = arguments?.getSerializable("biblioteca") as Biblioteca

        flLivroDestaque = view.findViewById(R.id.fl_livro_destaque)
        flLivroDestaque.setOnClickListener {
            val argumentos = Bundle()
            argumentos.putSerializable("livro", livro)
            argumentos.putSerializable("biblioteca", biblioteca)
            findNavController().navigate(if(activity is MenuBar) R.id.livro_visualization else R.id.livro_visualization_adm, argumentos)
        }

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
            Picasso.with(view.context).load("https://i.pinimg.com/236x/b4/9e/7a/b49e7a7298b855f8bf2cd3f5923ea7ab.jpg").into(imgLivro);
        }


    }


}
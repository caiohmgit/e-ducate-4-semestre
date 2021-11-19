package com.example.e_ducate

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.e_ducate.databinding.FragmentVisualizacaoLivroAdmBinding
import com.example.e_ducate.databinding.FragmentVisualizacaoLivroBinding
import com.squareup.picasso.Picasso

class VisualizacaoLivroAdmFragment : Fragment() {

    private var _binding: FragmentVisualizacaoLivroAdmBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentVisualizacaoLivroAdmBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val biblioteca:Biblioteca = arguments?.getSerializable("biblioteca") as Biblioteca
        val livro:Livro = arguments?.getSerializable("livro") as Livro


        val nomeBiblioteca: TextView = root.findViewById(R.id.nome_biblioteca)
        val nomeLivro: TextView = root.findViewById(R.id.nome_livro)
        val generoLivro: TextView = root.findViewById(R.id.genero_livro)
        val autorLivro: TextView = root.findViewById(R.id.autor_livro)
        val imgCapaLivro: ImageView = root.findViewById(R.id.img_livro)


        nomeBiblioteca.text = biblioteca.nome
        nomeLivro.text = livro.nome

        generoLivro.text = livro.genero
        autorLivro.text = livro.autor

        if (livro.urlCapaLivro != null) {
            if (livro.urlCapaLivro.contains("https")) {
                Picasso.with(view?.context).load(livro.urlCapaLivro).into(imgCapaLivro)
            } else {
                Picasso.with(view?.context).load(livro.urlCapaLivro?.replace("http", "https")).into(imgCapaLivro);
            }
        } else {
            Picasso.with(view?.context).load("https://i.pinimg.com/236x/b4/9e/7a/b49e7a7298b855f8bf2cd3f5923ea7ab.jpg").into(imgCapaLivro);
        }




        val buttonFechar: Button = root.findViewById(R.id.btn_fechar)
        buttonFechar.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.livros_em_destaque)
        })

        val buttonVoltarTelaLivros: Button = root.findViewById(R.id.btn_voltar_aos_livros)
        buttonVoltarTelaLivros.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.livros_em_destaque)
        })

        return root

    }
}
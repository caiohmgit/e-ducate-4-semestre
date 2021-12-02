package com.example.e_ducate

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.e_ducate.databinding.FragmentAjudaBinding
import com.example.e_ducate.databinding.FragmentVisualizacaoMainBibliotecaBinding
import com.squareup.picasso.Picasso


class VisualizacaoMainBibliotecaFragment : Fragment() {

    private var _binding: FragmentVisualizacaoMainBibliotecaBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentVisualizacaoMainBibliotecaBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val biblioteca:Biblioteca = arguments?.getSerializable("biblioteca") as Biblioteca

        val buttonFechar: Button = root.findViewById(R.id.btn_fechar_tela_biblioteca)
        buttonFechar.setOnClickListener(View.OnClickListener {
            activity?.onBackPressed()
        })

        val buttonAvaliar: Button = root.findViewById(R.id.btn_avaliar_biblioteca)
        buttonAvaliar.setOnClickListener(View.OnClickListener {
            val argumentos = Bundle()
            argumentos.putSerializable("biblioteca", biblioteca)
            findNavController().navigate(R.id.avaliar_biblioteca, argumentos)
        })


        val buttonVerLivros: Button = root.findViewById(R.id.btn_ver_livros_da_biblioteca)
        buttonVerLivros.setOnClickListener(View.OnClickListener {
            val argumentos = Bundle()
            argumentos.putSerializable("biblioteca", biblioteca)
            findNavController().navigate(R.id.livros_em_destaque, argumentos)
        })


        val nomeBiblioteca: TextView = root.findViewById(R.id.nome_biblioteca)
        val descricaoBiblioteca: TextView = root.findViewById(R.id.desc_biblioteca)
        val enderecoBiblioteca: TextView = root.findViewById(R.id.endereco_biblioteca)
        val notaBiblioteca: TextView = root.findViewById(R.id.nota_biblioteca)
        val horarioFuncBiblioteca: TextView = root.findViewById(R.id.horario_func_biblioteca)
        val homeOfficeBiblioteca: TextView = root.findViewById(R.id.home_office_biblioteca)
        val imgBiblioteca: ImageView = root.findViewById(R.id.img_biblioteca)


        nomeBiblioteca.text = biblioteca.nome
        descricaoBiblioteca.text = biblioteca.descricao
        enderecoBiblioteca.text = biblioteca.localizacao.nomeRua

        if (biblioteca.nota != null) {
            notaBiblioteca.text = biblioteca.nota.toString()
        } else {
            notaBiblioteca.text = "---"
        }

        if (biblioteca.urlBiblio != null) {
            if (biblioteca.urlBiblio.contains("https")) {
                Picasso.with(root.context).load(biblioteca.urlBiblio).into(imgBiblioteca)
            } else {
                Picasso.with(root.context).load(biblioteca.urlBiblio?.replace("http", "https")).into(imgBiblioteca);
            }
        } else {
            Picasso.with(root.context).load("https://www.colunaitalo.com.br/upload/noticias/2243/capa_destaque_2_view.jpg").into(imgBiblioteca);
        }

        if (biblioteca.homeOffice) {
            homeOfficeBiblioteca.text = getString(R.string.sim)
        } else {
            homeOfficeBiblioteca.text = getString(R.string.nao)
        }

        horarioFuncBiblioteca.text = biblioteca.horarioFunc





        return root
    }


}
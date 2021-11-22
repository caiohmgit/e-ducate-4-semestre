package com.example.e_ducate

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.e_ducate.databinding.FragmentEditarBiblioInfoBasicasBinding
import com.example.e_ducate.databinding.FragmentEditarBiblioPalavrasChavesBinding

class EditarBiblioPalavrasChavesFragment : Fragment() {
    private var _binding: FragmentEditarBiblioPalavrasChavesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentEditarBiblioPalavrasChavesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val buttonFechar: Button = root.findViewById(R.id.btn_fechar)
        buttonFechar.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.editar_biblio_main)
        })

        val buttonAtualizar: Button = root.findViewById(R.id.btn_atualizar)
        buttonAtualizar.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.editar_biblio_main)
        })

        val buttonAcessoInternet: Button = root.findViewById(R.id.btn_acesso_internet)
        buttonAcessoInternet.setOnClickListener(View.OnClickListener {
            buttonAcessoInternet.isSelected = !buttonAcessoInternet.isSelected
        })

        val buttonEspacoEstudo: Button = root.findViewById(R.id.btn_espacos_estudo)
        buttonEspacoEstudo.setOnClickListener(View.OnClickListener {
            buttonEspacoEstudo.isSelected = !buttonEspacoEstudo.isSelected
        })

        val buttonLivrosCientificos: Button = root.findViewById(R.id.btn_livros_cientificos)
        buttonLivrosCientificos.setOnClickListener(View.OnClickListener {
            buttonLivrosCientificos.isSelected = !buttonLivrosCientificos.isSelected
        })

        val buttonComputDisponiveis: Button = root.findViewById(R.id.btn_comput_disponiveis)
        buttonComputDisponiveis.setOnClickListener(View.OnClickListener {
            buttonComputDisponiveis.isSelected = !buttonComputDisponiveis.isSelected
        })

        val buttonVariedadeLivros: Button = root.findViewById(R.id.btn_variedade_livros)
        buttonVariedadeLivros.setOnClickListener(View.OnClickListener {
            buttonVariedadeLivros.isSelected = !buttonVariedadeLivros.isSelected
        })

        val buttonEspacoSilencioso: Button = root.findViewById(R.id.btn_espaco_silencioso)
        buttonEspacoSilencioso.setOnClickListener(View.OnClickListener {
            buttonEspacoSilencioso.isSelected = !buttonEspacoSilencioso.isSelected
        })

        val buttonEspacoTrabalho: Button = root.findViewById(R.id.btn_workspace)
        buttonEspacoTrabalho.setOnClickListener(View.OnClickListener {
            buttonEspacoTrabalho.isSelected = !buttonEspacoTrabalho.isSelected
        })

        val buttonEventosCulturais: Button = root.findViewById(R.id.btn_eventos_culturais)
        buttonEventosCulturais.setOnClickListener(View.OnClickListener {
            buttonEventosCulturais.isSelected = !buttonEventosCulturais.isSelected
        })

        val buttonAluguelLivros: Button = root.findViewById(R.id.btn_aluguel_livros)
        buttonAluguelLivros.setOnClickListener(View.OnClickListener {
            buttonAluguelLivros.isSelected = !buttonAluguelLivros.isSelected
        })

        val buttonEspacoArLivre: Button = root.findViewById(R.id.btn_espaco_ar_livre)
        buttonEspacoArLivre.setOnClickListener(View.OnClickListener {
            buttonEspacoArLivre.isSelected = !buttonEspacoArLivre.isSelected
        })

        val buttonLivrosInfantis: Button = root.findViewById(R.id.btn_livros_infantis)
        buttonLivrosInfantis.setOnClickListener(View.OnClickListener {
            buttonLivrosInfantis.isSelected = !buttonLivrosInfantis.isSelected
        })

        val buttonCompraLivros: Button = root.findViewById(R.id.btn_compra_livros)
        buttonCompraLivros.setOnClickListener(View.OnClickListener {
            buttonCompraLivros.isSelected = !buttonCompraLivros.isSelected
        })


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
package com.example.e_ducate

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.e_ducate.databinding.FragmentEditarBiblioMainBinding
import com.example.e_ducate.databinding.FragmentHomeAdmBinding

class EditarBiblioMainFragment : Fragment() {
    private var _binding: FragmentEditarBiblioMainBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentEditarBiblioMainBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val buttonFechar: Button = root.findViewById(R.id.btn_fechar)
        buttonFechar.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.library_visualization_adm)
        })

        val buttonVoltar: Button = root.findViewById(R.id.btn_voltar)
        buttonVoltar.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.library_visualization_adm)
        })

        val buttonInfoBasicas: Button = root.findViewById(R.id.btn_informacoes_basicas)
        buttonInfoBasicas.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.editar_biblio_info_basicas)
        })

        val buttonEndereco: Button = root.findViewById(R.id.btn_endereco)
        buttonEndereco.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.editar_biblio_endereco)
        })

        val buttonPalavrasChaves: Button = root.findViewById(R.id.btn_palavras_chaves)
        buttonPalavrasChaves.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.editar_biblio_palavras_chaves)
        })

        val buttonVisualizacao: Button = root.findViewById(R.id.btn_visualizacao)
        buttonVisualizacao.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.editar_biblio_visualizacao)
        })




        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
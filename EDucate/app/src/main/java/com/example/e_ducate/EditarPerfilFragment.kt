package com.example.e_ducate

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.e_ducate.databinding.FragmentEditarPerfilBinding
import com.example.e_ducate.databinding.FragmentPerfilBinding


class EditarPerfilFragment : Fragment() {

    private var _binding: FragmentEditarPerfilBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentEditarPerfilBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val buttonFechar: Button = root.findViewById(R.id.btn_fechar_editar_perfil)
        buttonFechar.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.nav_profile)
        })

        val buttonIrTelaEditar: Button = root.findViewById(R.id.btn_salvar_informacoes_perfil)
        buttonIrTelaEditar.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.nav_profile)
        })


        return root

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
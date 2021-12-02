package com.example.e_ducate

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.e_ducate.databinding.FragmentTelaSucessoBibliotecaCadastradaBinding
import com.example.e_ducate.databinding.FragmentTelaSucessoCadastroBinding

class TelaSucessoCadastroFragment : Fragment() {

    private var _binding: FragmentTelaSucessoCadastroBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentTelaSucessoCadastroBinding.inflate(inflater, container, false)
        val root: View = binding.root




        return root

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
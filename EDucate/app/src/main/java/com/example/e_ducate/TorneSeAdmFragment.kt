package com.example.e_ducate

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.e_ducate.databinding.FragmentAjudaBinding
import com.example.e_ducate.databinding.FragmentTorneSeAdmBinding


class TorneSeAdmFragment : Fragment() {

    private var _binding: FragmentTorneSeAdmBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentTorneSeAdmBinding.inflate(inflater, container, false)
        val root: View = binding.root


        val buttonCancelar: Button = root.findViewById(R.id.btn_cancelar)
        buttonCancelar.setOnClickListener(View.OnClickListener {
            activity?.onBackPressed()
        })

        val buttonEnviar: Button = root.findViewById(R.id.btn_enviar_solicitacao)
        buttonEnviar.setOnClickListener(View.OnClickListener {
            Toast.makeText(context, "Funcionalidade em desenvolvimento!", Toast.LENGTH_SHORT).show()
        })


        return root

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}
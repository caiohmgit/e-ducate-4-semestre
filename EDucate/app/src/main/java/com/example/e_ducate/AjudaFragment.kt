package com.example.e_ducate

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentContainer
import androidx.navigation.fragment.findNavController
import com.example.e_ducate.databinding.FragmentAjudaBinding
import com.example.e_ducate.databinding.FragmentContatoBinding
import android.widget.Button
import android.widget.Toast


class AjudaFragment : Fragment() {


    private var _binding: FragmentAjudaBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentAjudaBinding.inflate(inflater, container, false)
        val root: View = binding.root


        val buttonFechar: Button = root.findViewById(R.id.btn_fechar_ajuda)
        buttonFechar.setOnClickListener(View.OnClickListener {
            activity?.onBackPressed()
//            findNavController().navigate(if(activity is MenuBar) R.id.nav_home else R.id.nav_home_adm)

        })

        val buttonAjuda: Button = root.findViewById(R.id.btn_ajuda)
        buttonAjuda.setOnClickListener(View.OnClickListener {
            Toast.makeText(context, "Funcionalidade em desenvolvimento!", Toast.LENGTH_SHORT).show()
        })


        return root

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }





}
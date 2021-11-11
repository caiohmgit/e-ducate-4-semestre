package com.example.e_ducate

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlin.system.exitProcess
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.e_ducate.databinding.FragmentContatoBinding
import com.example.e_ducate.databinding.FragmentHomeBinding
import com.example.e_ducate.ui.home.HomeFragment


class ContatoFragment : Fragment() {

    private var _binding: FragmentContatoBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentContatoBinding.inflate(inflater, container, false)
        val root: View = binding.root


        return root

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }






//    fun irTelaHomeUsuario() {
//
//        val fragmentManager: FragmentManager? = activity?.supportFragmentManager
//
//        val fragmentTransaction: FragmentTransaction? = fragmentManager?.beginTransaction()
//
//        fragmentTransaction?.replace(R.id.nav_home, HomeFragment())?.commit()
//    }


}
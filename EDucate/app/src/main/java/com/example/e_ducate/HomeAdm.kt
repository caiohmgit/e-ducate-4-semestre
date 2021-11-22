package com.example.e_ducate

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.navigation.fragment.findNavController
import com.example.e_ducate.databinding.FragmentHomeAdmBinding
import com.example.e_ducate.databinding.FragmentHomeBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeAdm : Fragment() {
    private var _binding: FragmentHomeAdmBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentHomeAdmBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val buttonExplorar: Button = root.findViewById(R.id.btn_explorar)
        buttonExplorar.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.library_visualization_adm)
        })




        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
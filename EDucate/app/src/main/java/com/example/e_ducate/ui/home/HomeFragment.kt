package com.example.e_ducate.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.e_ducate.Biblioteca
import com.example.e_ducate.BibliotecaPesquisaFragment
import com.example.e_ducate.ClientRest
import com.example.e_ducate.R
import com.example.e_ducate.databinding.FragmentHomeBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root


        val resultadoBusca: LinearLayout = root.findViewById(R.id.ll_bibliotecas_recomendadas)
        resultadoBusca.removeAllViews()

        val clientAPIBiblioteca = ClientRest.criarClientBiblioteca()

        clientAPIBiblioteca?.getBibliotecas()?.enqueue(object : Callback<List<Biblioteca>> {
            override fun onResponse(
                call: Call<List<Biblioteca>>,
                response: Response<List<Biblioteca>>
            ) {
                if (response.isSuccessful) {

                    val transaction = activity?.supportFragmentManager?.beginTransaction()
                    response.body()?.forEach {

                        val params = Bundle()
                        params.putSerializable("biblioteca", it)


                        val fragment = BibliotecaPesquisaFragment()

                        fragment.arguments = params
                        transaction?.add(R.id.ll_bibliotecas_recomendadas, fragment)

                    }

                    transaction?.commit()
                }
            }

            override fun onFailure(call: Call<List<Biblioteca>>, t: Throwable) {
                Log.e("API Biblioteca", t.message!!)
                Toast.makeText(context, "Erro na chamada da API", Toast.LENGTH_SHORT).show()
            }

        })


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
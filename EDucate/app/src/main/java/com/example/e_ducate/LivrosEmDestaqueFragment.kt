package com.example.e_ducate

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.e_ducate.databinding.FragmentHomeBinding
import com.example.e_ducate.databinding.FragmentLivrosEmDestaqueBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LivrosEmDestaqueFragment : Fragment() {
    private var _binding: FragmentLivrosEmDestaqueBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentLivrosEmDestaqueBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val buttonFechar: Button = root.findViewById(R.id.btn_fechar)
        buttonFechar.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.nav_home)
        })

        val biblioteca:Biblioteca = arguments?.getSerializable("dados") as Biblioteca

        val nomeBiblioteca:TextView = root.findViewById(R.id.nome_biblioteca)

        nomeBiblioteca.text = biblioteca.nome

        val exibicaoLivros: LinearLayout = root.findViewById(R.id.ll_livros_em_destaque)
        exibicaoLivros.removeAllViews()

        val clientAPIBiblioteca = ClientRest.criarClientBiblioteca()

        clientAPIBiblioteca?.getLivrosDaBiblioteca(biblioteca.id)?.enqueue(object : Callback<List<Livro>> {
            override fun onResponse(
                call: Call<List<Livro>>,
                response: Response<List<Livro>>
            ) {
                if (response.isSuccessful) {
                    val transaction = activity?.supportFragmentManager?.beginTransaction()
                    response.body()?.forEach {

                        val params = Bundle()
                        params.putSerializable("livro", it)


                        val fragment = LivroDestaqueFragment()

                        fragment.arguments = params
                        transaction?.add(R.id.ll_livros_em_destaque, fragment)

                    }

                    transaction?.commit()
                }
            }

            override fun onFailure(call: Call<List<Livro>>, t: Throwable) {
//                    Log.e("API Biblioteca", t.message!!)
//                    Toast.makeText(context, "Erro na chamada da API", Toast.LENGTH_SHORT).show()
            }

        })


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
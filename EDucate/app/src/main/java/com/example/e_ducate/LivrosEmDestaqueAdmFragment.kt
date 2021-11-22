package com.example.e_ducate

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.navigation.fragment.findNavController
import com.example.e_ducate.databinding.FragmentLivrosEmDestaqueAdmBinding
import com.example.e_ducate.databinding.FragmentLivrosEmDestaqueBinding
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LivrosEmDestaqueAdmFragment : Fragment() {

    private var _binding: FragmentLivrosEmDestaqueAdmBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentLivrosEmDestaqueAdmBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val biblioteca:Biblioteca = arguments?.getSerializable("biblioteca") as Biblioteca

        val buttonFechar: Button = root.findViewById(R.id.btn_fechar)
        buttonFechar.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.library_visualization_adm)
        })

        val buttonAdicionarLivro: Button = root.findViewById(R.id.btn_adicionar_livro)
        buttonAdicionarLivro.setOnClickListener(View.OnClickListener {
            var argumentos = Bundle()
            argumentos.putSerializable("biblioteca", biblioteca)
            findNavController().navigate(R.id.adicionar_livro_fragment, argumentos)
        })


        val nomeBiblioteca:TextView = root.findViewById(R.id.nome_biblioteca)

        nomeBiblioteca.text = biblioteca.nome

        val exibicaoLivros: LinearLayout = root.findViewById(R.id.ll_livros_em_destaque_adm)
        exibicaoLivros.removeAllViews()

        val clientAPIBiblioteca = ClientRest.criarClientBiblioteca()

        clientAPIBiblioteca?.getLivrosDaBiblioteca(biblioteca.id)?.enqueue(object :
            Callback<List<Livro>> {
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
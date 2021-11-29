package com.example.e_ducate

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.navigation.fragment.findNavController
import com.example.e_ducate.databinding.FragmentPesquisaBibliotecasBinding
import com.example.e_ducate.databinding.FragmentVisualizacaoMainBibliotecaBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class PesquisaBibliotecasFragment : Fragment() {
    private var _binding: FragmentPesquisaBibliotecasBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentPesquisaBibliotecasBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val etPesquisa :EditText = root.findViewById(R.id.et_pesquisa_bibliotecas)
        val termoPesquisado : String = etPesquisa.text.toString()

        val tvResultadoBusca :TextView = root.findViewById(R.id.frase_resultado_pesquisa)

        val mensagemResultado = "Resultado para busca de $termoPesquisado"

        val buttonFechar: Button = root.findViewById(R.id.btn_fechar)
        buttonFechar.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.nav_home)
        })

        val buttonBuscar: ImageView = root.findViewById(R.id.btn_buscar)
        buttonBuscar.setOnClickListener {

            tvResultadoBusca.text = mensagemResultado
            val resultadoBusca: LinearLayout = root.findViewById(R.id.ll_resultado_busca_bibliotecas)
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
                            transaction?.add(R.id.ll_resultado_busca_bibliotecas, fragment)

                        }

                        transaction?.commit()
                    }
                }

                override fun onFailure(call: Call<List<Biblioteca>>, t: Throwable) {
                    Log.e("API Biblioteca", t.message!!)
//                    Toast.makeText(context, "Erro na chamada da API", Toast.LENGTH_SHORT).show()
                }

            })
        }




        return root
    }
}
package com.example.e_ducate

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.e_ducate.databinding.FragmentAjudaBinding
import com.example.e_ducate.databinding.FragmentPerfilBinding
import com.squareup.picasso.Picasso
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class PerfilFragment : Fragment() {


    private var _binding: FragmentPerfilBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentPerfilBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val usuario:Usuario = arguments?.getSerializable("usuario") as Usuario


        val nomeUsuario: TextView = root.findViewById(R.id.nome_usuario)
        val emailUsuario: TextView = root.findViewById(R.id.email_usuario)
        val telefoneUsuario: TextView = root.findViewById(R.id.telefone_usuario)
        val urlPerfilUsuario: ImageView = root.findViewById(R.id.imagem_perfil)

        val buttonFechar: Button = root.findViewById(R.id.btn_fechar_perfil)
        buttonFechar.setOnClickListener(View.OnClickListener {
            activity?.onBackPressed()

        })


        val params = Bundle()

        val buttonIrTelaEditar: Button = root.findViewById(R.id.btn_editar_informacoes)
        buttonIrTelaEditar.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.editar_perfil, params)
        })


        val clientAPIBiblioteca = ClientRest.criarClientBiblioteca()

        if (usuario == null) {
            clientAPIBiblioteca?.getUsuario(1)?.enqueue(object :
                Callback<Usuario> {
                override fun onResponse(
                    call: Call<Usuario>,
                    response: Response<Usuario>
                ) {
                    if (response.isSuccessful) {
                        nomeUsuario.text = response.body()?.nome
                        emailUsuario.text = response.body()?.email
                        telefoneUsuario.text = response.body()?.telefone


                        if (response.body()?.urlPerfil != null) {
                            if (response.body()?.urlPerfil!!.contains("https")) {
                                Picasso.with(root.context).load(response.body()?.urlPerfil).into(urlPerfilUsuario)
                            } else {
                                Picasso.with(root.context).load(response.body()?.urlPerfil?.replace("http", "https")).into(urlPerfilUsuario);
                            }

                        } else {
                            Picasso.with(root.context).load("https://hospitalevandroribeiro.com.br/images/no-photo.png").into(urlPerfilUsuario);
                        }

                        params.putSerializable("usuario", response.body())

                    }

                }


                override fun onFailure(call: Call<Usuario>, t: Throwable) {
                    Log.e("API Biblioteca", t.message!!)
                    //                    Toast.makeText(context, "Erro na chamada da API", Toast.LENGTH_SHORT).show()
                }

            })
        } else {
            clientAPIBiblioteca?.getUsuario(usuario.id)?.enqueue(object :
                Callback<Usuario> {
                override fun onResponse(
                    call: Call<Usuario>,
                    response: Response<Usuario>
                ) {
                    if (response.isSuccessful) {
                        nomeUsuario.text = response.body()?.nome
                        emailUsuario.text = response.body()?.email
                        telefoneUsuario.text = response.body()?.telefone


                        if (response.body()?.urlPerfil != null) {
                            if (response.body()?.urlPerfil!!.contains("https")) {
                                Picasso.with(root.context).load(response.body()?.urlPerfil).into(urlPerfilUsuario)
                            } else {
                                Picasso.with(root.context).load(response.body()?.urlPerfil?.replace("http", "https")).into(urlPerfilUsuario);
                            }

                        } else {
                            Picasso.with(root.context).load("https://hospitalevandroribeiro.com.br/images/no-photo.png").into(urlPerfilUsuario);
                        }

                        params.putSerializable("usuario", response.body())

                    }

                }


                override fun onFailure(call: Call<Usuario>, t: Throwable) {
                    Log.e("API Biblioteca", t.message!!)
                    //                    Toast.makeText(context, "Erro na chamada da API", Toast.LENGTH_SHORT).show()
                }

            })
        }











        return root

    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        val usuario:Usuario = arguments?.getSerializable("usuario") as Usuario
//

//
//    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}

package com.example.e_ducate

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.e_ducate.databinding.FragmentEditarPerfilBinding
import com.example.e_ducate.databinding.FragmentPerfilBinding
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class EditarPerfilFragment : Fragment() {

    private var _binding: FragmentEditarPerfilBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentEditarPerfilBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val etNomeUsuario : EditText = root.findViewById(R.id.et_nome_usuario)
        val etEmailUsuario : EditText = root.findViewById(R.id.et_email_usuario)
        val etTelefoneUsuario : EditText = root.findViewById(R.id.et_telefone_usuario)
        val etUrlImagemUsuario : EditText = root.findViewById(R.id.et_url_imagem_perfil)

        val urlPerfilUsuario: ImageView = root.findViewById(R.id.imagem_perfil)

        val usuario : Usuario = arguments?.getSerializable("usuario") as Usuario


        etNomeUsuario.setText(usuario.nome)
        etEmailUsuario.setText(usuario.email)
        etTelefoneUsuario.setText(usuario.telefone)
        etUrlImagemUsuario.setText(usuario.urlPerfil)

        if (usuario.urlPerfil != null) {
            if (usuario.urlPerfil!!.contains("https")) {
                Picasso.with(root.context).load(usuario.urlPerfil).into(urlPerfilUsuario)
            } else {
                Picasso.with(root.context).load(usuario.urlPerfil!!.replace("http", "https")).into(urlPerfilUsuario);
            }

        } else {
            Picasso.with(root.context).load("https://hospitalevandroribeiro.com.br/images/no-photo.png").into(urlPerfilUsuario);
        }




        val buttonFechar: Button = root.findViewById(R.id.btn_fechar_editar_perfil)
        buttonFechar.setOnClickListener(View.OnClickListener {
            activity?.onBackPressed()
        })

        val buttonAtualizarInformacoesPerfil: Button = root.findViewById(R.id.btn_salvar_informacoes_perfil)
        buttonAtualizarInformacoesPerfil.setOnClickListener(View.OnClickListener {


            usuario.nome = etNomeUsuario.text.toString()
            usuario.email = etEmailUsuario.text.toString()
            usuario.telefone = etTelefoneUsuario.text.toString()
            usuario.urlPerfil = etUrlImagemUsuario.text.toString()

            val clientAPIBiblioteca = ClientRest.criarClientBiblioteca()

            clientAPIBiblioteca?.putUsuario(usuario.id, usuario)?.enqueue(object :
                Callback<Usuario> {
                override fun onResponse(
                    call: Call<Usuario>,
                    response: Response<Usuario>
                ) {
                    if (response.isSuccessful) {
                        Toast.makeText(context, "Informações do perfil atualizadas com sucesso!", Toast.LENGTH_SHORT).show()
                        activity?.onBackPressed()

                    }

                }

                override fun onFailure(call: Call<Usuario>, t: Throwable) {
                    Log.e("API Biblioteca", t.message!!)
                    Toast.makeText(context, "Informações do perfil atualizadas com sucesso!", Toast.LENGTH_SHORT).show()
                    activity?.onBackPressed()
                }

            })



        })




        return root

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
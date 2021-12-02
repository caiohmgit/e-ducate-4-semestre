package com.example.e_ducate

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.navigation.fragment.findNavController
import com.example.e_ducate.databinding.FragmentEditarPerfilBinding
import com.example.e_ducate.databinding.FragmentPerfilBinding
import com.squareup.picasso.Picasso


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
            if (usuario.urlPerfil.contains("https")) {
                Picasso.with(root.context).load(usuario.urlPerfil).into(urlPerfilUsuario)
            } else {
                Picasso.with(root.context).load(usuario.urlPerfil.replace("http", "https")).into(urlPerfilUsuario);
            }

        } else {
            Picasso.with(root.context).load("https://hospitalevandroribeiro.com.br/images/no-photo.png").into(urlPerfilUsuario);
        }




        val buttonFechar: Button = root.findViewById(R.id.btn_fechar_editar_perfil)
        buttonFechar.setOnClickListener(View.OnClickListener {
            activity?.onBackPressed()
        })

        val buttonIrTelaPerfil: Button = root.findViewById(R.id.btn_salvar_informacoes_perfil)
        buttonIrTelaPerfil.setOnClickListener(View.OnClickListener {
            activity?.onBackPressed()
        })


        return root

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
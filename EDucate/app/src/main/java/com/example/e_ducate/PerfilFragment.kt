package com.example.e_ducate

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.e_ducate.databinding.FragmentAjudaBinding
import com.example.e_ducate.databinding.FragmentPerfilBinding
import com.squareup.picasso.Picasso


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

        val buttonFechar: Button = root.findViewById(R.id.btn_fechar_perfil)
        buttonFechar.setOnClickListener(View.OnClickListener {
            findNavController().navigate(if(activity is MenuBar) R.id.nav_home else R.id.nav_home_adm)

        })

        val buttonIrTelaEditar: Button = root.findViewById(R.id.btn_editar_informacoes)
        buttonIrTelaEditar.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.editar_perfil)
        })


        return root

    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        val usuario:Usuario = arguments?.getSerializable("usuario") as Usuario
//
//        val nomeUsuario: TextView = view.findViewById(R.id.nome_usuario)
//        val emailUsuario: TextView = view.findViewById(R.id.email_usuario)
//        val telefoneUsuario: TextView = view.findViewById(R.id.telefone_usuario)
//        val urlPerfilUsuario: ImageView = view.findViewById(R.id.imagem_perfil)
//
//
//
//        nomeUsuario.text = usuario.nome
//        emailUsuario.text = usuario.email
//        telefoneUsuario.text = usuario.telefone
//
//
//        if (usuario.urlPerfil != null) {
//            if (usuario.urlPerfil.contains("https")) {
//                Picasso.with(view.context).load(usuario.urlPerfil).into(urlPerfilUsuario)
//            } else {
//                Picasso.with(view.context).load(usuario.urlPerfil?.replace("http", "https")).into(urlPerfilUsuario);
//            }
//
//        } else {
//            Picasso.with(view.context).load("https://www.google.com/url?sa=i&url=https%3A%2F%2Fvoxnews.com.br%2Ftwitter-muda-imagem-padrao-de-perfis-sem-foto%2F&psig=AOvVaw2Ge0oL9r0lLwl1aaHpMEQx&ust=1636755132248000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCMCYvZaqkfQCFQAAAAAdAAAAABAJ").into(urlPerfilUsuario);
//        }
//
//    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}

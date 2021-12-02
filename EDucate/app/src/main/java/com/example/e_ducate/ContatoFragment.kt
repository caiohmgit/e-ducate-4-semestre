package com.example.e_ducate

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlin.system.exitProcess
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.acessoeducateuser.models.UserBody
import com.example.e_ducate.databinding.FragmentContatoBinding
import com.example.e_ducate.databinding.FragmentHomeBinding
import com.example.e_ducate.ui.home.HomeFragment
import okhttp3.ResponseBody
import retrofit2.Response


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

        val buttonFechar: Button = root.findViewById(R.id.btn_fechar_contato)
        buttonFechar.setOnClickListener(View.OnClickListener {
            activity?.onBackPressed()
//            findNavController().navigate(if(activity is MenuBar) R.id.nav_home else R.id.nav_home_adm)
        })

        val etPrimeiroNome: EditText = root.findViewById(R.id.et_primeiro_nome)

        val etUltimoNome: EditText = root.findViewById(R.id.et_ultimo_nome)

        val etEmailContato: EditText = root.findViewById(R.id.et_email_contato)

        val etNumeroTelefone: EditText = root.findViewById(R.id.et_numero_telefone)

        val etMensagemContato: EditText = root.findViewById(R.id.et_mensagem_contato)

        val clientAPIBiblioteca = ClientRest.criarClientBiblioteca()

       // clientAPIBiblioteca?postContato()

        return root

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


//    private fun signup(nome: String, email: String, senha: String,
//                       telefone: String){
//        val retIn = ClientRest.criarClientBiblioteca()!!
//        val registerInfo = UserBody(nome,email,senha,telefone)
//
//        retIn.registerCtt(registerInfo).enqueue(object :
//            retrofit2.Callback<ResponseBody> {
//            override fun onFailure(call: retrofit2.Call<ResponseBody>, t: Throwable) {
//                Toast.makeText(
//                    applicationContext,
//                    t.message,
//                    Toast.LENGTH_SHORT
//                ).show()
//            }
//            override  fun onResponse(call: retrofit2.Call<ResponseBody>, response: Response<ResponseBody>) {
//                if (response.code() == 201) {
//                    Toast.makeText(applicationContext, "Registration success!", Toast.LENGTH_SHORT)
//                        .show()
//
//                }
//                else{
//                    Toast.makeText(applicationContext, "Registration failed!", Toast.LENGTH_SHORT)
//                        .show()
//                }
//            }
//        })
//    }


}
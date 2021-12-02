package com.example.e_ducate

import android.graphics.drawable.Drawable
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
import com.example.e_ducate.databinding.FragmentAvaliarBibliotecaBinding

class AvaliarBibliotecaFragment : Fragment() {

    private var _binding: FragmentAvaliarBibliotecaBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    var nota: Double = 0.0


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentAvaliarBibliotecaBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val biblioteca:Biblioteca = arguments?.getSerializable("biblioteca") as Biblioteca


        val buttonFechar: Button = root.findViewById(R.id.btn_fechar_tela_biblioteca)
        buttonFechar.setOnClickListener(View.OnClickListener {
            activity?.onBackPressed()
        })

        val buttonCancelar: Button = root.findViewById(R.id.btn_cancelar)
        buttonCancelar.setOnClickListener(View.OnClickListener {
            activity?.onBackPressed()
        })

        val nomeBiblioteca:TextView = root.findViewById(R.id.nome_biblioteca)

        nomeBiblioteca.text = biblioteca.nome



        val estrela1: ImageView = root.findViewById(R.id.star_rate1)
        val estrela2: ImageView = root.findViewById(R.id.star_rate2)
        val estrela3: ImageView = root.findViewById(R.id.star_rate3)
        val estrela4: ImageView = root.findViewById(R.id.star_rate4)
        val estrela5: ImageView = root.findViewById(R.id.star_rate5)

        val estrelaAmarela : Drawable? = activity?.getDrawable(R.drawable.ic_star_rate)
        val estrelaCinza : Drawable? = activity?.getDrawable(R.drawable.ic_star_rate_grey)

        // Funcionalidade das estrelas

        estrela1.setOnClickListener(View.OnClickListener {
            estrela1.setImageDrawable(estrelaAmarela)
            estrela2.setImageDrawable(estrelaCinza)
            estrela3.setImageDrawable(estrelaCinza)
            estrela4.setImageDrawable(estrelaCinza)
            estrela5.setImageDrawable(estrelaCinza)

            nota = 1.0
        })

        estrela2.setOnClickListener(View.OnClickListener {
            estrela1.setImageDrawable(estrelaAmarela)
            estrela2.setImageDrawable(estrelaAmarela)
            estrela3.setImageDrawable(estrelaCinza)
            estrela4.setImageDrawable(estrelaCinza)
            estrela5.setImageDrawable(estrelaCinza)

            nota = 2.0
        })

        estrela3.setOnClickListener(View.OnClickListener {
            estrela1.setImageDrawable(estrelaAmarela)
            estrela2.setImageDrawable(estrelaAmarela)
            estrela3.setImageDrawable(estrelaAmarela)
            estrela4.setImageDrawable(estrelaCinza)
            estrela5.setImageDrawable(estrelaCinza)

            nota = 3.0
        })

        estrela4.setOnClickListener(View.OnClickListener {
            estrela1.setImageDrawable(estrelaAmarela)
            estrela2.setImageDrawable(estrelaAmarela)
            estrela3.setImageDrawable(estrelaAmarela)
            estrela4.setImageDrawable(estrelaAmarela)
            estrela5.setImageDrawable(estrelaCinza)

            nota = 4.0
        })

        estrela5.setOnClickListener(View.OnClickListener {
            estrela1.setImageDrawable(estrelaAmarela)
            estrela2.setImageDrawable(estrelaAmarela)
            estrela3.setImageDrawable(estrelaAmarela)
            estrela4.setImageDrawable(estrelaAmarela)
            estrela5.setImageDrawable(estrelaAmarela)

            nota = 5.0
        })


        return root

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}
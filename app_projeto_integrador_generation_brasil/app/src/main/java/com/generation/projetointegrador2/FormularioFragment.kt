package com.generation.projetointegrador2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.generation.projetointegrador2.adapter.PostagensAdapter
import com.generation.projetointegrador2.databinding.FragmentFormularioBinding
import com.generation.projetointegrador2.databinding.FragmentPostagemBinding
import androidx.recyclerview.widget.RecyclerView


class FormularioFragment : Fragment() {

    private lateinit var binding: FragmentFormularioBinding
    //private lateinit var mainViewModel: MainViewModel

    //Momento em que a view está sendo criada

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //essa variável recebe o layout que será criado
        binding = FragmentFormularioBinding.inflate(layoutInflater, container, false)

//botão sendo criado para construção da view

        binding.buttonPostagem.setOnClickListener {


            if (binding.editDescricao.text.isEmpty() || binding.editTitulo.text.isEmpty() || binding.editTextLinkImagem.text.isEmpty()) {
                Toast.makeText(context, "Preencha todos os dados", Toast.LENGTH_SHORT).show()
            } else {
                findNavController().navigate(R.id.action_formularioFragment_to_postagemFragment)
                Toast.makeText(context, "Postagem publicada!", Toast.LENGTH_SHORT).show()
            }
//retornando a view para visualização

        }
        return binding.root

    }
}
package com.generation.projetointegrador2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.generation.projetointegrador2.adapter.PostagensAdapter
import com.generation.projetointegrador2.model.Formulario
import com.google.android.material.floatingactionbutton.FloatingActionButton

class PostagemFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_postagem, container, false)

        val listaPostagens = mutableListOf(
            //1
            Formulario("Celso Dantas", "Distribuição de agasalhos na igreja.", "Link",
            "Roupas","22/03/2022 - 09:43"),
            //2
            Formulario("Brian Sato", "Doação de alimentos para moradores de rua.", "Link",
            "Alimentos", "30/03/2022 - 10:32"),
            //3
            Formulario("Leticia Franco", "Doação de produtos de higiene para família carentes.","Link",
            "Higiene","03/04/2022 - 14:10")
        )

        val recyclerPostagem = view.findViewById<RecyclerView>(R.id.recycleFeed)

        val adapter = PostagensAdapter()

        recyclerPostagem.layoutManager = LinearLayoutManager(context)

        recyclerPostagem.adapter = adapter

        recyclerPostagem.setHasFixedSize(true)

        adapter.setLista(listaPostagens)

        var buttonAdd = view.findViewById<FloatingActionButton>(R.id.buttonMais)

        buttonAdd.setOnClickListener(){
            findNavController().navigate(R.id.action_postagemFragment_to_formularioFragment)
        }


        return view


    }


}
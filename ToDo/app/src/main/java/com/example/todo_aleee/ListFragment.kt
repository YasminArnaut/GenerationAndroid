package com.example.todo_aleee

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todo_aleee.adapter.TarefaAdapter
import com.example.todo_aleee.databinding.FragmentListBinding
import com.example.todo_aleee.util.MainViewModel

class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentListBinding.inflate(layoutInflater, container, false)

        val adapter = TarefaAdapter()

        //Definir o Layout Manager da RecyclerView
        binding.recyclerTarefa.layoutManager = LinearLayoutManager(context)

        //Passar o adapter criado para o recyclerTarefa
        binding.recyclerTarefa.adapter = adapter

        //Definir a lista para ter um tamanho fixo independente dos itens
        binding.recyclerTarefa.setHasFixedSize(true)



        //Navegação para o Fragment de Form
        binding.floatingAdd.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_formFragment3)
        }

        viewModel.listCategoria()

        viewModel.reponseListCategoria.observe(viewLifecycleOwner) {
                response -> Log.d("Requisicao", response.body().toString())

        }


        return binding.root

    }

}
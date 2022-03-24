package com.example.todo

import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.R
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todo.adapter.TarefaAdapter
import com.example.todo.databinding.FragmentListBinding
import com.example.todo.model.Tarefa
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListFragment() : Fragment(){

    private lateinit var binding: FragmentListBinding
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentListBinding.inflate(layoutInflater, container, false)

        //Instaciar o adapter
        val adapter = TarefaAdapter()

        //Definir o Layout Manager da RecyclerView
        binding.recyclerView.layoutManager = LinearLayoutManager(context)

        //Passar o adapter criado para o recyclerTarefa
        binding.recyclerView.adapter = adapter

        //Definir a lista para ter um tamanho fixo indepedente dos itens
        binding.recyclerView.setHasFixedSize(true)

        //Navegação para o Fragment de Form
        binding.floatingAdd.setOnClickListener {
            findNavController().navigate(com.example.todo.R.id.listParaFormulario)


        }
        viewModel.listCategoria()

        viewModel.reponseListCategoria.observe(viewLifecycleOwner){
                response -> Log.d("Requisicao", response.body().toString())
        }
        return binding.root
    }
}
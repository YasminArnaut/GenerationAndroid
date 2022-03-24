package com.example.todo

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.todo.databinding.FragmentFromBinding
import com.example.todo.repository.Repository

class FormFragment : Fragment() {

    private lateinit var binding: FragmentFromBinding
    private val mainViewModel: MainViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFromBinding.inflate(layoutInflater, container, false)

        mainViewModel.listCategoria()

        mainViewModel.reponseListCategoria.observe(viewLifecycleOwner){
                response -> Log.d("Requisicao", response.body().toString())
        }

        binding.ButtonSalvar.setOnClickListener{
            findNavController().navigate(R.id.listParaFormulario)
        }

        return binding.root
    }

}
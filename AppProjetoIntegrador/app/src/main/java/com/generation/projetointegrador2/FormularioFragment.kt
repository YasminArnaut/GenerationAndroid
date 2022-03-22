package com.generation.projetointegrador2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController

class FormularioFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view1 = inflater.inflate(R.layout.fragment_formulario, container, false)

        val buttonPostar = view1.findViewById<Button>(R.id.buttonPostagem)

        buttonPostar.setOnClickListener{
            findNavController().navigate(R.id.action_formularioFragment_to_postagemFragment)
        }


        return view1
    }


}
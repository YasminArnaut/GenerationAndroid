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
import com.generation.projetointegrador2.databinding.FragmentFormularioBinding
import com.generation.projetointegrador2.databinding.FragmentPostagemBinding
import com.generation.projetointegrador2.model.Formulario
import com.google.android.material.floatingactionbutton.FloatingActionButton

class PostagemFragment : Fragment() {

    private lateinit var binding: FragmentPostagemBinding
    //private lateinit var mainViewModel: MainViewModel

    //Momento em que a view está sendo criada
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //essa variável recebe o layout que será criado
        binding = FragmentPostagemBinding.inflate(layoutInflater, container, false)

        //Criando a lista de postagem que irá popular o fragmento postagem
        //pra isso, é necessário passar a classe tipo *Formulario*
        val listaPostagens = mutableListOf(
            //1
            Formulario("Distribuição de agasalhos","Celso Dantas", "ação solidária na igreja.", "Link",
            "Roupas","22/03/2022 - 09:43"),
            //2
            Formulario("Doação de alimentos","Brian Sato", "Doação de alimentos para moradores de rua.", "Link",
            "Alimentos", "30/03/2022 - 10:32"),
            //3
            Formulario("Doação de produtos higiene","Leticia Franco", "Doação de produtos de higiene para família carentes.","Link",
            "Higiene","03/04/2022 - 14:10")
        )

        //instanciando a lista de postagem com o RecryclerView localizado pelo ID.

        //criando o adapter // adapter é responsável por cuidar do RecyclerView
        val adapter = PostagensAdapter()

        //chamando a variável RecryclerPostagem com o método layoutManager
        //recebendo o tipo de Layout que ele terá
        binding.recycleFeed.layoutManager = LinearLayoutManager(context)

        //falando pro RecyclerView que ele está recebendo um adapter que vai cuidar dele
        binding.recycleFeed.adapter = adapter

        //falando que haverá um tamanho fixo
        binding.recycleFeed.setHasFixedSize(true)

        adapter.setLista(listaPostagens)

        binding.buttonMais.setOnClickListener(){
            findNavController().navigate(R.id.action_postagemFragment_to_formularioFragment)
        }


        return binding.root


    }

}
package com.example.todo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todo.adapter.TarefaAdapter
import com.example.todo.model.Tarefa


class BlankFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_blank, container, false)
        val BlankFragment = mutableListOf(

            Tarefa(
                "Limpar Banheiro",
                "Iniciar na parte da manhã",
                "Yasmin",
                "2022-24-03",
                true,
                "Dia a Dia",
            ),
                Tarefa(
                    "Lavar o quintal",
                    "Iniciar na parte da Tarde",
                    "Yasmin",
                    "2022-26-03",
                    true,
                    "Uma vez na semana",
                ),

            Tarefa(
                "Ir ao Shopping",
                "Passear com a familia",
                "Yasmin",
                "2022-22-03",
                true,
                "Lazer",
            ),
        )

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        val adapter = TarefaAdapter()

        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter
        recyclerView.setHasFixedSize(true)
        adapter.setLista(BlankFragment)

        return view


    }
}


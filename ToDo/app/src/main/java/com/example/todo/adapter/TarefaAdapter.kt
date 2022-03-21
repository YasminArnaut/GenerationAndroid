package com.example.todo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.todo.R
import com.example.todo.model.Tarefa


class TarefaAdapter: RecyclerView.Adapter<TarefaAdapter.BlankViewHolder>() {

    private var BlankFragment = emptyList<Tarefa>()

    class BlankViewHolder (view: View): RecyclerView.ViewHolder(view){

        val txtnome = view.findViewById<TextView>(R.id.txtNome)
        val txtdescricao = view.findViewById<TextView>(R.id.txtDescricao)
        val txtresponsavel = view.findViewById<TextView>(R.id.txtResponsavel)
        val txtdata = view.findViewById<TextView>(R.id.txtData)
        val swtandamento = view.findViewById<Switch>(R.id.swtAndamento)
        val txtcategoria = view.findViewById<TextView>(R.id.txtCategoria)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlankViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.cardview_tarefas,parent,false)
        return BlankViewHolder(layout)
    }

    override fun onBindViewHolder(holder: BlankViewHolder, position: Int) {

        holder.txtnome.text = BlankFragment[position].nome
        holder.txtdescricao.text = BlankFragment[position].descricao
        holder.txtresponsavel.text = BlankFragment[position].responsavel
        holder.txtdata.text = BlankFragment[position].data
        holder.swtandamento.isChecked = BlankFragment[position].status
        holder.txtcategoria.text = BlankFragment[position].categoria


    }
    override fun getItemCount(): Int {
    return BlankFragment.size
    }
        fun setLista(lista: List<Tarefa>){
            BlankFragment = lista
            notifyDataSetChanged()
        }
}
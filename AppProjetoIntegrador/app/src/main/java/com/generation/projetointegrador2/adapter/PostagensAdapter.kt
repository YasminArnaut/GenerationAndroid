package com.generation.projetointegrador2.adapter

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.generation.projetointegrador2.R
import com.generation.projetointegrador2.model.Formulario

class PostagensAdapter: RecyclerView.Adapter<PostagensAdapter.PostagemViewHolder>() {

    private var listaPostagens = emptyList<Formulario>()

    class PostagemViewHolder(view: View): RecyclerView.ViewHolder(view){

        val textNomeUsuario = view.findViewById<TextView>(R.id.textNomeUsu)
        val textPostagemTexto = view.findViewById<TextView>(R.id.textPostagemTexto)
        val textImagemLink = view.findViewById<TextView>(R.id.editTextLinkImagem)
        val imagePostagem = view.findViewById<ImageView>(R.id.imagePostagem)
        val textCategoria = view.findViewById<TextView>(R.id.textCategoria)
        val textDataHora = view.findViewById<TextView>(R.id.textDataEHora)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PostagensAdapter.PostagemViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.card_layout_post, parent,false)

        return PostagemViewHolder(layout)
    }

    override fun onBindViewHolder(holder: PostagensAdapter.PostagemViewHolder, position: Int) {

        val postagem = listaPostagens[position]

        holder.textNomeUsuario.text = postagem.nomeUsuario
        holder.textPostagemTexto.text = postagem.postagem

        holder.textCategoria.text = postagem.categoria
        holder.textDataHora.text = postagem.dataHora


    }

    override fun getItemCount(): Int {
        return listaPostagens.size
    }

    fun setLista(lista: List<Formulario>){
        listaPostagens = lista

        notifyDataSetChanged()
    }


}
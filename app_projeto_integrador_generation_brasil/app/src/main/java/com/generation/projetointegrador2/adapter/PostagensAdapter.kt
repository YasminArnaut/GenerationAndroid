package com.generation.projetointegrador2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.generation.projetointegrador2.R
import com.generation.projetointegrador2.model.Postagem

//Criando a classe a PostagensAdapter que precisará de uma segunda classe
//RecyclerView.Adapter diz que a minha classe será um adapter
//<PostagensAdapter.PostagemViewHolder> diz que PostagensAdapter será do tipo ViewHolder
class PostagensAdapter: RecyclerView.Adapter<PostagensAdapter.PostagemViewHolder>() {

    //criando uma variável listaPostagens vazia.
    //Passando "Formulário" entre as tags para dizer qual o tipo de lista que essa var irá receber
    private var listaPostagens = emptyList<Postagem>()

    //a classe abaixo deve existir para o adapter existir. É necessário o ViewHolder
    class PostagemViewHolder(view: View): RecyclerView.ViewHolder(view){

//Instanciando as variáveis com o ID dos componentes
        val textNomeUsuario = view.findViewById<TextView>(R.id.textNomeUsu)
        val textPostagemTexto = view.findViewById<TextView>(R.id.textPostagemTexto)
        val textImagemLink = view.findViewById<TextView>(R.id.editTextLinkImagem)
        val imagePostagem = view.findViewById<ImageView>(R.id.imagePostagem)
        val textCategoria = view.findViewById<TextView>(R.id.textCategoria)
        val textDataHora = view.findViewById<TextView>(R.id.textDataEHora)
        val cardTitulo = view.findViewById<TextView>(R.id.tituloCard)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostagensAdapter.PostagemViewHolder {

        //Definindo qual o Layout que será utilizado no nosso RecyclerView
        //No caso, estamos dizendo que utilizaremos o card
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.card_layout_post, parent,false)

        //no fim, retornamos a classe PostagemViewHolder
        //PostagemViewHolder(layout) - passando o layout no constructor da class PostagemViewHolder
        //Passando o componente que criamos para ser o Layout da RecycleView
        return PostagemViewHolder(layout)
    }

    //Holder nos permite acessar as variáveis dentro da classe

    override fun onBindViewHolder(holder: PostagensAdapter.PostagemViewHolder, position: Int) {

        //var postagem está recebendo listaPostagens que criamos vazia no começo do código

        //é necessário colocar o position, que funcionará como um for
        val postagem = listaPostagens[position]

        //holder acessa o id pré-definido e recebe var postagem
        holder.textNomeUsuario.text = postagem.autor
        holder.textPostagemTexto.text = postagem.descricao
        holder.cardTitulo.text = postagem.titulo
        holder.textCategoria.text = postagem.tema.descricao
        holder.textDataHora.text = postagem.dataHora


    }

    //Onde vamos dizer para o Adapter quantos itens temos na lista
    override fun getItemCount(): Int {
        return listaPostagens.size
    }

    //criando uma função recebendo uma lista<e o tipo>
    //listaPostagens = lista - listaPostagens está recebendo a lista passada na função
    fun setLista(lista: List<Postagem>){
        listaPostagens = lista

        //esse método diz quando a lista mudou e atualiza a lista
        notifyDataSetChanged()
    }


}
package com.rafaela.sofieproject.UI.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rafaela.sofieproject.Models.Tarefa
import com.rafaela.sofieproject.R

//criando o adapter

class TarefaAdapter(private val context: Context, private val lista: ArrayList<Tarefa> ): RecyclerView.Adapter<TarefaAdapter.TarefaViewHolder>() {


     class TarefaViewHolder (itemView: View): RecyclerView.ViewHolder(itemView){

         val titulo: TextView = itemView.findViewById(R.id.titleTarefa)
         val email: TextView = itemView.findViewById(R.id.email)
         val descricao: TextView = itemView.findViewById(R.id.descricao)

     }

    override fun onCreateViewHolder(parent:ViewGroup, viewType:Int): TarefaViewHolder {

    val view = LayoutInflater.from(context).inflate(R.layout.item_list,parent,false)
    return TarefaViewHolder(view)
}

    override fun getItemCount(): Int {
        return lista.size
    }

    override fun onBindViewHolder(holder: TarefaViewHolder, position: Int) {
        //holder.titulo.text = lista[position].title
        holder.titulo.text = lista[position].title
        holder.email.text = lista[position].email
        holder.descricao.text = lista[position].description

    }


}
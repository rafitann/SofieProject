package com.rafaela.sofieproject.Models

import org.json.JSONArray

class Tarefas{

   private val lista = arrayListOf<Tarefa>()



    fun converteObjeto(items: JSONArray):ArrayList<Tarefa>{
        (0 until items.length()).forEach {
            val item = items.getJSONObject(it)

            lista.add(
                Tarefa(

                    item.getString("_id"),
                    item.getString("title"),
                    item.getString("email"),
                    item.getString("description"),
                    item.getString("when")

                )
            )
        }
        return lista
    }
}
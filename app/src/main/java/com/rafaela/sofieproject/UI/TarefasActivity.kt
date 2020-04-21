package com.rafaela.sofieproject.UI

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.rafaela.sofieproject.Okhttp.Config
import com.rafaela.sofieproject.Models.Tarefas
import com.rafaela.sofieproject.R
import com.rafaela.sofieproject.UI.Adapter.TarefaAdapter
import kotlinx.android.synthetic.main.activity_tarefas.*
import okhttp3.*
import org.json.JSONObject
import java.io.IOException


class TarefasActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tarefas)

        btnnovaTarefa.setOnClickListener {

            startActivity(Intent(this@TarefasActivity, NovaTarefaActivity::class.java))
        }

        val recyclerView = recyclewTarefas
        val  layoutManager = LinearLayoutManager(
            this@TarefasActivity, LinearLayoutManager.VERTICAL, false)

        recyclerView.layoutManager = layoutManager


        val client = Config().okhttp("GET").enqueue(object : Callback{
            override fun onFailure(call: Call, e: IOException) {
                println("Falha ao se conectar ")

            }

            override fun onResponse(call: Call, response: Response) {

                val body = response.body?.string()
                val json = JSONObject(body!!)

                val tarefas = Tarefas().converteObjeto(json.getJSONArray("data"))

                runOnUiThread{
                    recyclerView.adapter = TarefaAdapter(this@TarefasActivity,tarefas)
                }

            }

        })

    }



}








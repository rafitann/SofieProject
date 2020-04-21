package com.rafaela.sofieproject.Okhttp

import android.app.DownloadManager
import android.telecom.Call
import okhttp3.OkHttpClient
import okhttp3.Request
import java.lang.reflect.Method

class Config {
    private  val url = "https://9g1borgfz0.execute-api.sa-east-1.amazonaws.com/beta/task"

    fun okhttp(httpMethod: String): okhttp3.Call{
        val request = Request.Builder()
            .url(url)
            .method("GET",null)
            .build()

        val client = OkHttpClient().newBuilder().build()

        return client.newCall(request)
    }
}
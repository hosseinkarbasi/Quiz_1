package com.example.queiz1

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import okhttp3.Call
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.IOException
import java.util.concurrent.Callable
import java.util.concurrent.Executors
import java.util.concurrent.Future


class One : Fragment(R.layout.one) {

    private val client by lazy { OkHttpClient() }
    private lateinit var tv: TextView
    private val executor by lazy { Executors.newSingleThreadExecutor() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tv = view.findViewById(R.id.tv)

        val request = Request.Builder()
            .url("https://api.github.com/users/hosseinkarbasi")
            .build()

        try {
            val future: Future<String?> = executor.submit(Callable<String?> {
                val newCall: Call = client.newCall(request)
                val response: Response = newCall.execute()
                response.body()?.string()
            })
            val data: String? = future.get()
            tv.text = data
        } catch (e: IOException) {
            tv.text = e.javaClass.simpleName + " " + e.message
        }
    }
}
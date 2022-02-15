package com.example.queiz1

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import okhttp3.*
import java.io.IOException

class Two : Fragment(R.layout.two) {
    private val client by lazy { OkHttpClient() }
    private lateinit var tv: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tv = view.findViewById(R.id.tv)

        val request = Request.Builder()
            .url("https://api.github.com/users/hosseinkarbasi")
            .build()

        val newCall: Call = client.newCall(request)
        newCall.enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                setResult(e.message)
            }

            override fun onResponse(call: Call, response: Response) {
                setResult(response.body()?.string())
            }
        })
    }

    private fun setResult(data: String?) {
        Handler(Looper.getMainLooper()).post {
            tv.text = data
        }
    }
}
package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.*
import android.widget.Toast
import java.lang.UnsupportedOperationException


class MainActivity : AppCompatActivity() {

    private val BASE_URL = "https://autorizadorwebpay2.coopeuch.cl/login"
    //private val BASE_URL = "https://d2805y70vmyrh9.cloudfront.net/login?trackId=5c82f49171494df8b637f8d56d67a59a"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        var sView : WebView = findViewById(R.id.webView)
        sView.webChromeClient = object : WebChromeClient(){}

        sView.webViewClient = object : WebViewClient(){
            override fun onReceivedError(
                view: WebView?,
                request: WebResourceRequest?,
                error: WebResourceError?
            ) {
                super.onReceivedError(view, request, error)
                Toast.makeText(this@MainActivity,"error: $error",Toast.LENGTH_LONG).show()
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                Toast.makeText(this@MainActivity,"OK Cargo Todo bien",Toast.LENGTH_LONG).show()
            }
        }

        var settings: WebSettings = sView.settings
        settings.javaScriptEnabled = true
        settings.domStorageEnabled = true

        try {
            sView.loadUrl(BASE_URL.toString())

        }catch (e:UnsupportedOperationException) {
            e.printStackTrace()
        }


    }
}
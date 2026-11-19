package com.rfm.mushaf

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient

class MainActivity : Activity() {

    private lateinit var web: WebView

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        web = WebView(this)
        setContentView(web)

        web.settings.apply {
            javaScriptEnabled = true
            domStorageEnabled = true      // لحفظ آخر موضع قراءة
            blockNetworkLoads = true      // لا اتصال بالإنترنت إطلاقًا
            allowFileAccess = true
            allowContentAccess = false
            textZoom = 100
        }

        web.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, request: WebResourceRequest): Boolean {
                val url = request.url
                if (url.scheme == "tel") {
                    startActivity(Intent(Intent.ACTION_DIAL, url))   // يفتح الاتصال فقط
                }
                return url.scheme != "file"
            }
        }

        web.loadUrl("file:///android_asset/index.html")
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        web.evaluateJavascript("window.handleBack && window.handleBack()") { result ->
            if (result != "true") finish()
        }
    }
}

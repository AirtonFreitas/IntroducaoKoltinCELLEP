package com.iasoftwares.appestacaohack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import com.iasoftwares.appestacaohack.databinding.ActivityWebBinding

class WebActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWebBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Habilitar a exec de JavaScript
        binding.wbvWeb.settings.javaScriptEnabled = true

        // Definindo a página inicial
        binding.wbvWeb.loadUrl("https://br.cellep.com/estacaohack")
        // Definir o WebView como padrão na aplicação
        binding.wbvWeb.webViewClient = WebViewClient()
    }
}
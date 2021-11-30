package com.iasoftwares.appestacaohack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.iasoftwares.appestacaohack.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //Inicializar a variavel Binding
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Referencia os Id da página para uso no Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        //Substituição da Supervariável R para o ROOT
        setContentView(binding.root)
    }
}
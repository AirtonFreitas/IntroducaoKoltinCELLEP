package com.iasoftwares.appestacaohack

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.iasoftwares.appestacaohack.databinding.CadastroActivityBinding

class CadastroActivity : AppCompatActivity() {d
    private lateinit var binding: CadastroActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = CadastroActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val listaContinentes =
            arrayListOf("Continente", "Africa", "Antártida", "América", "Europa", "Oceania", "Asia")
        val spinnerAdapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, listaContinentes)
        binding.spnCadastroContinente.adapter = spinnerAdapter

        val nome = binding.edtCadastroNome.text.toString().trim()
        val sobrenome = binding.edtCadastroSobrenome.text.toString().trim()
        val email = binding.edtCadastroEmail.text.toString().trim()
        val senha = binding.edtCadastroSenha.text.toString().trim()
        val continente = binding.spnCadastroContinente.selectedItem.toString()

        if(nome.isEmpty() || sobrenome.isEmpty() || email.isEmpty() || senha.isEmpty() || continente == listaContinentes[0]){
            Toast.makeText(this, "Algum campo está vazio!", Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(this, "Cadastro ok", Toast.LENGTH_LONG).show()
            val sharedPrefs = getSharedPreferences(
                "cadastro_$email", Context.MODE_PRIVATE
            )
            val editPrefs = sharedPrefs.edit()

            val hashSenha = hashCode(senha)

            
            
            
            editPrefs.putString("NOME", nome)
            editPrefs.putString("SOBRENOME", sobrenome)
            editPrefs.putString("EMAIL", email)
            editPrefs.putString("SENHA", hashSenha)
            editPrefs.putString("CONTINENTE", continente)
            editPrefs.apply()
            Toast.makeText(this, "Cadastro ok", Toast.LENGTH_LONG).show()


        }

    }
}
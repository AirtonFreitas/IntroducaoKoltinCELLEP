package com.iasoftwares.appestacaohack

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.iasoftwares.appestacaohack.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLoginEntrar.setOnClickListener {
            val email = binding.editLoginEmail.text.toString().trim().lowercase()
            val senha = binding.editLoginSenha.text.toString().trim()
            if (email.isEmpty()) {
                binding.editLoginEmail.error = "Campo Obrigatório"
                binding.editLoginEmail.requestFocus()
            } else if (senha.isEmpty()) {
                binding.editLoginSenha.error = "Campo Obrigatório"
                binding.editLoginSenha.requestFocus()
            } else {

                val sharedPrefs = getSharedPreferences("cadastro_$email", Context.MODE_PRIVATE)

                val emailPrefs = sharedPrefs.getString("EMAIL", "")
                val senhaPrefs = sharedPrefs.getString("SENHA", "")

                if (email == emailPrefs && Hash().md5(senha) == senhaPrefs) {
                    Toast.makeText(this, "Usuário Logado", Toast.LENGTH_SHORT).show()
                    val mIntent = Intent(this, MainActivity::class.java)
                    mIntent.putExtra("INTENT_EMAIL", email)
                    startActivity(mIntent)
                    finish()
                } else {
                    Toast.makeText(this, "E-mail ou Senha inválidos", Toast.LENGTH_SHORT).show()
                }

            }
        }

        binding.btnCadastrar.setOnClickListener {
            val mIntent = Intent(this, CadastroActivity::class.java)
            startActivity(mIntent)
        }
    }
}
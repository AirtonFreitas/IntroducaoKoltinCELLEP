package com.iasoftwares.appestacaohack

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
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
        val email = intent.getStringExtra("INTENT_EMAIL")
        //Toast.makeText(this, email, Toast.LENGTH_LONG).show()

        val sharedPrefs = getSharedPreferences(
            "cadastro_$email",
            Context.MODE_PRIVATE
        )

        val nome = sharedPrefs.getString("NOME", "")
        val sobrenome = sharedPrefs.getString("SOBRENOME", "")
        val continente = sharedPrefs.getString("CONTINENTE", "")

        binding.txvMainNome.text = "$nome $sobrenome"
        binding.txvMainEmail.text = email
        binding.txvMainContinente.text = continente


        binding.btnMainSair.setOnClickListener{
            val alert = AlertDialog.Builder(this,)
            alert.setTitle("Atenção")
            alert.setMessage("Deseja mesmo sair?")
            alert.setNeutralButton("Não"){ dialog, whitch ->

            }

            alert.setPositiveButton("Sair"){ dialog, whitch ->
                val mIntent = Intent(this, LoginActivity::class.java)
                startActivity(mIntent)
                finishAffinity()
            }
            alert.setNegativeButton("Negativo"){ dialog, whitch ->

            }
            alert.setCancelable(false)
            alert.show()
        }

        binding.btnMainSite.setOnClickListener {
            val mIntent = Intent(this, WebActivity::class.java)
            startActivity(mIntent)
        }

    }
}
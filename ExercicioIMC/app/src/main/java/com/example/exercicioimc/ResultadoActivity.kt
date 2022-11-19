package com.example.exercicioimc

import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.CalendarContract.Colors
import com.example.exercicioimc.databinding.ActivityDadosImcBinding
import com.example.exercicioimc.databinding.ActivityResultadoBinding

class ResultadoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultadoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultadoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        iniciarDados()
    }

    private fun iniciarDados() {
        val nome = intent.getStringExtra(ActivityDadosIMC.TAG_NOME)
        val text = intent.getStringExtra(ActivityDadosIMC.TAG_RESULTADO)
        val alerta = intent.getStringExtra(ActivityDadosIMC.TAG_ALERTA)
        val faixaEtaria = intent.getStringExtra(ActivityDadosIMC.TAG_FAIXA_ETARIA)

        binding.txtResultado.text = text
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            binding.txtResultado.setBackgroundColor(
                resources.getColor(
                    Integer.valueOf(alerta),
                    null
                )
            )
        } else {
            binding.txtResultado.setBackgroundColor(resources.getColor(Integer.valueOf(alerta)))
        }

        binding.txtPaciente.text = "Paciente: " + nome?.toString() ?: ""
                                    " " + faixaEtaria.toString() + " encontra se: "

    }
}
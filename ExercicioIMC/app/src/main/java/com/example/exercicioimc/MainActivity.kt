package com.example.exercicioimc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.exercicioimc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        abrirTelaDadosIMC()
    }

    private fun abrirTelaDadosIMC() {
        binding.calcular.setOnClickListener {
            val intent = Intent(this, ActivityDadosIMC::class.java)
            startActivity(intent)
        }
    }
}
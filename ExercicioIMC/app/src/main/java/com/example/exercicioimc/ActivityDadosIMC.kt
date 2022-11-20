package com.example.exercicioimc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import com.example.exercicioimc.databinding.ActivityDadosImcBinding

class ActivityDadosIMC : AppCompatActivity() {

    private lateinit var binding: ActivityDadosImcBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDadosImcBinding.inflate(layoutInflater)
        setContentView(binding.root)

        calculoIMC()
    }

    private fun calculoIMC() {

        binding.btnEnviar.setOnClickListener {
            val peso = binding.edtPeso.text.toString()
            val altura = binding.edtAltura.text.toString()
            //Recuperando os valores
            if(verificaInputs()){
                val imc = realizaCalculo(peso.toDouble(), altura.toDouble())
                checarIMC(imc)
            } else {
                Toast.makeText(this, "Campos preenchidos indevidamente!", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun verificaInputs(): Boolean {
        if(binding.edtPeso.text.toString() == ""){
            binding.edtPeso.setError(("Peso é obrigatório"))
            return false
        }else if(binding.edtAltura.text.toString() == ""){
            binding.edtAltura.setError("Altura é obrigatória")
            return false
        }else if(binding.rgClassificacaoIdade.checkedRadioButtonId == 0){
            return false
        }
        return true
    }

    private fun checarIMC(imc: Double) {
        var resultado = ""
        var alerta = ""
        val faixaEtariaSelecionadaId = binding.rgClassificacaoIdade.checkedRadioButtonId
        var faixaEtaria = findViewById<RadioButton>(faixaEtariaSelecionadaId).text.toString()

        when(imc){
            in 0.0..18.5 -> {
                resultado = resources.getString(R.string.Abaixo_do_Peso)
                alerta = R.color.blue.toString()
            }
            in 18.6..24.9 -> {
                resultado = resources.getString(R.string.Peso_normal)
                alerta = R.color.green.toString()
            }
            in 25.0..29.9 -> {
                resultado = resources.getString(R.string.Sobrepeso)
                alerta = R.color.yellow.toString()
            }
            in 30.0..34.9 -> {
                resultado = resources.getString(R.string.Obesidade_Grau_I)
                alerta = R.color.orange.toString()
            }
            in 35.0..39.9 -> {
                resultado = resources.getString(R.string.Obesidade_Grau_II)
                alerta = R.color.red.toString()
            }
            in 40.0..Double.MAX_VALUE -> {
                resultado = resources.getString(R.string.Obesidade_Grau_III)
                alerta = R.color.redDark.toString()
            }
        }
        criaResultado(resultado, faixaEtaria, alerta)
    }

    private fun criaResultado(r: String, f:String, a: String) {
        val intent = Intent(this, ResultadoActivity::class.java)
        intent.putExtra(TAG_RESULTADO, r)
        intent.putExtra(TAG_ALERTA, a)
        intent.putExtra(TAG_FAIXA_ETARIA, f)
        intent.putExtra(TAG_NOME, binding.edtNome.text.toString()?:"")
        startActivity(intent)
    }

    private fun realizaCalculo(peso: Double, altura: Double): Double {
        return peso/(altura*altura)
    }

    companion object {
        const val TAG_RESULTADO = "RESULTADO_IMC"
        const val TAG_NOME = "NOME"
        const val TAG_ALERTA = "ALERTA"
        const val TAG_FAIXA_ETARIA = "FAIXA_ETARIA"
    }
}
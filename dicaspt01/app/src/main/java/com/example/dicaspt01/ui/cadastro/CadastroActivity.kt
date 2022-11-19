package com.example.dicaspt01.ui.cadastro

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.RadioButton
import androidx.annotation.RequiresApi
import com.example.dicaspt01.ui.cadastro.main.MainActivity
import com.example.dicaspt01.R
import com.example.dicaspt01.RegistroPeso
import com.example.dicaspt01.databinding.ActivityCadastroBinding

class CadastroActivity : AppCompatActivity() {
    lateinit var binding: ActivityCadastroBinding
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val text = intent.getStringExtra(MainActivity.TAG)
        Log.d("PUCMINAS::D",
        intent.getStringExtra(MainActivity.TAG) ?: "Nenhum dado foi passado")

        configListeners()
    }

    private fun configListeners() {
        configurarEnviar()
        configurarRG()
    }

    private fun configurarEnviar() {
        binding.btnEnviar.setOnClickListener {
            salvarPeso()
        }
    }

    private fun salvarPeso() {
        val peso = binding.edtExemplo.text.toString().toDouble()
        val faixaEtaria = validarIdade()

        Intent().apply {
            putExtra(
                MainActivity.TAG,
                RegistroPeso(
                    peso = peso,
                    faixaEtaria = faixaEtaria
                )
            )
            setResult(RESULT_OK, this)
        }
        finish()
    }

    /*private fun inicializarDados() {
        val resultado = intent.getStringExtra(MainActivity.TAG)
        //binding.txtResultado.text = resultado
    }*/

    fun validarIdade(): String{
        val radio = binding.rgClassificacaoIdade
        val rbSelectedId = binding.rgClassificacaoIdade.checkedRadioButtonId
        return findViewById<RadioButton>(rbSelectedId).text.toString()
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun configurarRG(): String {
        var retorno:String = ""
        binding.rgClassificacaoIdade.setOnCheckedChangeListener { group, checkedId ->
            when(checkedId) {
                R.id.rbAdulto -> {
                    mudarCorBotao(1)
                    retorno = getString(R.string.adulto_lbl)
                }
                R.id.rbIdoso -> {
                    mudarCorBotao(2)
                    retorno = getString(R.string.idoso_lbl)
                }
                else -> {

                }
            }
        }
        return retorno
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun mudarCorBotao(i: Int) {
        val color = when(i) {
            1 -> {
                getColor(R.color.black)
            }
            else -> {
                getColor(R.color.teal_700)
            }
        }
        binding.btnEnviar.setBackgroundColor(color)
    }
}
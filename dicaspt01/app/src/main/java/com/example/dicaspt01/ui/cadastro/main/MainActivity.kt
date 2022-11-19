package com.example.dicaspt01.ui.cadastro.main

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import com.example.dicaspt01.RegistroPeso
import com.example.dicaspt01.ui.cadastro.CadastroActivity
import com.example.dicaspt01.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private val mainViewModel:MainViewModel by viewModels()
    private val retornoActivity = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ){ activityResult ->
        if(activityResult.resultCode == RESULT_OK){
            activityResult.data?.let{
                if(it.hasExtra(TAG)){
                    val retorno = if(Build.VERSION.SDK_INT >= 33) {
                        it.getParcelableExtra(TAG, RegistroPeso::class.java)
                    }else{
                        it.getParcelableExtra(TAG)
                    }
                    Log.d("PUCMINAS::D", retorno.toString())
                }
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        configurarListeners()
        configObservers()
    }

    private fun configObservers() {

    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun configurarListeners() {
        configurarFabListener()
    }

    private fun configurarFabListener() {
        binding.fabNovaActivity.setOnClickListener{
            iniciarNovaActivity()
        }
    }

    private fun iniciarNovaActivity() {
        /*val peso = binding.edtExemplo.text.toString()
        val intent = Intent(this, CadastroActivity::class.java).apply {
            putExtra(TAG, peso)
        }*/

        //startActivity(intent)

        Intent(this, CadastroActivity::class.java).let {
            retornoActivity.launch((it))
        }
    }

    companion object {
        const val TAG = "PUC_EXEMPLO_INTENT"
    }
}

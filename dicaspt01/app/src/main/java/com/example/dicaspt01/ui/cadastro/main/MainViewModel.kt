package com.example.dicaspt01.ui.cadastro.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.dicaspt01.RegistroPeso

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val _listaPeso = MutableLiveData<List<RegistroPeso>>(mutableListOf())
    val listaPeso: LiveData<List<RegistroPeso>> = _listaPeso

    fun salvarNovoRegistro(registroPeso: RegistroPeso){
        // Se a lista for nula eu mando uma lista vazia
        val lista = _listaPeso.value?.toMutableList() ?: mutableListOf()
        lista.add(registroPeso)
        _listaPeso.value = lista
    }
}
package com.example.dicaspt01

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RegistroPeso(
    val peso: Double,
    val faixaEtaria: String
    ): Parcelable

package com.example.javakotlin

data class EstudantePucKotlin(
    var uid: String,
    var primeiroNome: String,
    var segundoNome: String,
    var idade: Int
)

class EstudanteCasoDeUso {
    fun buscarEstudandoPuc() : EstudantePucKotlin {
        // val é imutável, podendo ser atribuido uma única vez.
        val numero = 10
        // var pode ser mudada.
        var outronumero = 10

        // A linha abaixo dá erro.
        //numero = 20


        outronumero = 20

        val estudantePuc = EstudantePucKotlin(
            "puc001",
            "Fábio",
            "Almeida",
            37
        )
        return estudantePuc
    }
}

fun main(){
    val estudante = EstudanteCasoDeUso()
    println("Exemplo de impressão usando toString(): " + estudante.buscarEstudandoPuc())
}
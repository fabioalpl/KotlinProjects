package com.example.javakotlin

fun main(){
    //Não é permitido inserir null
    //Deve se colocar ? no caso do tipo poder ser null
    var nome: String?
    //nome = null

    val frutas = listOf("banana", "maça", "limão")
    var index: Int?

    index = null

    //Elvis operator
    //Utilizado para não cair no nullPointer
    println(frutas[index?:0])
}
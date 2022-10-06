package com.example.javakotlin

fun soma2(a: Int, b: Int) : Int {
    return a + b
}

fun somaSimples(a: Int, b: Int) = a + b

class Retangulo(var largura: Double, var altura: Double){
    fun area(): Double = largura * altura
}

fun masOf(a:Int, b:Int): Int{
    /*if(a>b){
        return a
    } else {
        return b
    }*/

    // Forma simplificada
    // Observação: retorna a última linha do comando if ou else
    return if(a>b) a else b
}

fun main(){
    val resultado: Int
    var resultado2: Int = 0

    println("Olá")
    println("Boas vindas ao Kotlin")
    println(soma2(4,5))
    println("Impressão da função soma2 " + somaSimples(4,5))
    resultado = somaSimples(4,5)
    println("Impressão da função somaSimples ${resultado}")
    println("Impressão da função somaSimples ${somaSimples(a = 10,b = 25)}")

    var a = 10
    var s1 = "a é $a"
    a = 25
    val s2 = "${s1.replace("é","era")}, mas agora é $a"
    println(s1)
    println(s2)
}
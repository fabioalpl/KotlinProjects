package com.example.javakotlin

// Seria o case
// Pode se omitir o tipo de retorno
fun describe (obj: Any): String =
    when(obj){
        1 -> {
            println("Option one selected.")
            "One"
        }
        2 -> "Two"
        "Hello" -> "Greeting"
        is Long -> "Long"
        !is String -> "Is not a String"
        // Default
        else -> "Unknown"
    }

fun main() {
    // Não é preciso definir o tipo da lista.
    val items = listOf("apple", "banana", "kiwifruit")

    //foreach
    for(item in items){
        println(item)
    }

    // pegando o index
    for(index in items.indices){
        println("Item $index é ${items[index]}")
    }
    println("--------------------------------------/---------------------------------------")
    var index = 0

    while (index < items.size) {
        println("Item ${index + 1} é ${items[index]}")
        index ++
    }

    println(describe(1))
    println(describe(2))
    println("Hello")
    println(describe(145_381_732_918_372))
    println(describe(3.1415))
}
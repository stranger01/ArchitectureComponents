import java.lang.Integer.sum

/**
 * Aca vamos repasando lo que ha pasado
 * es importante repasar
 * */

fun main() {


    var age = 30
    var weight = 135.2
    var name = "jose"
    var married = true
    var willingToRelocate = false

    var isYoung = age < 50

    println("Jose is isYoung? ${age}")



    if (isYoung) {
        println("go ahead")
    } else {
        println("pedile permiso a tu mama")
    }


    //Array and Lists

    var names = listOf("Jose", "Antonio", "Martinez", "Perez")
    println(names[1])


    var countries = mutableListOf("El Salvador", "Guatemala", "Colombia")
    println()


    //for loop

    for (country in countries) {
        println(country)
        println()
    }

    //maps

    var ages = mapOf("Juan" to 26, "Alberto" to 31, "Jonathan" to 36, "Rafael" to 32)
    for (participants in ages) {
        println(participants)
        println()
    }

    //functions

    fun helloFunction() {
        println("hello from here!")

    }

    for (x in 1..10) {
        helloFunction()
    }

    fun sumAnB(num1: Int, num2: Int): Int {

        return num1 + num2

    }

    var sum = sumAnB(4, 6)

    println()
    print("El resultado de esta suma es ${sum}")
    println()

    //Classes

    class Car {
        var brand = ""
        var color = ""
        var price = 0
        var type = ""

        fun infoCar(){
            println("El color es ${color}")
        }

    }

    var myCar = Car()
    myCar.brand = "Renault"
    myCar.color = "rojo"
    myCar.price = 7000
    myCar.type = "sedan"
    myCar.infoCar()

    println("el carro es ${myCar.brand}")

}
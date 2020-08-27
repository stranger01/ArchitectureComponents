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
    countries[0] = "United States"
    countries.add(3, "Chile")
    print(countries[3])




}
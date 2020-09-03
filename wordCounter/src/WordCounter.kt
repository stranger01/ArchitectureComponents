

fun main() {

    val allTheWords = "Hello there, my name is Jose, I love the fucking pizza"

    val words = allTheWords.replace("e", "o")

    var wordMap = mutableMapOf<String, Int>()
    for(eachWord in words) {
        println(eachWord)

    }


}
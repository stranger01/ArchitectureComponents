import java.io.File
import java.io.InputStream

fun main() {

    val inputStream: InputStream = File("test.txt").inputStream()

    val allTheWords = inputStream.bufferedReader().use { it.readText() }

    val words = allTheWords.replace("a", "7").replace("b", "B").replace("c", "1")


    for (word in words) {
        print(word.toString())
    }

}
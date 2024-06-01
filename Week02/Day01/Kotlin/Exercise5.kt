import kotlin.math.PI
import kotlin.math.pow


fun main() {
    // Exercise 5
    print("What is the radius of the sphere: ")
    val response = readln().toDouble()

    //pi=3.14
    val volume = (4.0 / 3.0) * PI * response.pow(3)

    println("Volume is: $volume")
}


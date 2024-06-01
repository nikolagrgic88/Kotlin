import kotlin.math.pow
import kotlin.math.sqrt

class Point(var x: Double, var y: Double) {

    fun distance(point: Point): Double {
        val distance = sqrt((x - point.x).pow(2) + (y - point.y).pow(2))
        return distance
//        var distance = sqrt(())
    }
}


fun main() {
    val bgd = Point(44.8125, 20.4612)
    val syd = Point(33.8688, 151.2093)
    val mel = Point(37.8136, 144.9631)
    val bri = Point(27.4705, 153.0260)

    println(bri.distance(syd))
}
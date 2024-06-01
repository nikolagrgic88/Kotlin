import kotlin.math.PI
import kotlin.math.pow

interface Shape {
    fun calculateArea():Double
}

class Triangle(var base: Int, var height: Int) : Shape {

    override fun calculateArea(): Double {
        return (base * height / 2).toDouble()

    }
}

class Rectangle(var width: Int, var height: Int) : Shape {
    override fun calculateArea(): Double {
        return (width * height).toDouble()
    }
}

class Circle(var radius: Int) : Shape {
    override fun calculateArea(): Double {
        return (PI * radius.toDouble().pow(2.0))
    }
}

fun getArea(shape: Shape): Double {
    return shape.calculateArea()
}

fun main() {

    println(getArea(Triangle(2, 2)))
    println(getArea(Rectangle(2, 2)))
    println(getArea(Circle(5)))

}
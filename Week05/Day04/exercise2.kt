open class TrafficLight() {

    open fun nextLight(): TrafficLight {
        return TrafficLight()
    }

    open fun outputLight() {
        println("Traffic Light")

    }
}

class Red() : TrafficLight() {
    override fun nextLight(): TrafficLight {
        return Green()
    }

    override fun outputLight() {
        println("Green light")
    }
}

class Green() : TrafficLight() {
    override fun nextLight(): TrafficLight {
        return Yellow()
    }

    override fun outputLight() {
        println("Yellow light")
    }
}

class Yellow() : TrafficLight() {
    override fun nextLight(): TrafficLight {
        return Red()
    }

    override fun outputLight() {
        println("Red light")
    }
}

fun main() {
    var light:TrafficLight = Red()
    var line = readlnOrNull()
    while (line != null) {
        light.outputLight()
        light = light.nextLight()
        line = readlnOrNull()
        // ^ mostly just for hitting enter and moving to the next light
    }
}
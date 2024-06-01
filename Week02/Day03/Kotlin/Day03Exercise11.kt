class LightSwitch(var locationName: String, var swithchedOn: Boolean) {

    fun swith() {
        //toggle between on and off
        swithchedOn = !swithchedOn
    }
}

fun main() {
    var room1 = LightSwitch("Leaving Room", true)
    var room2 = LightSwitch("Bedroom", false)

    room1.swith()
    room2.swith()
    println(room1.swithchedOn)
    println(room2.swithchedOn)
}
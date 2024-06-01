class TrafficLight(var currentLight: String) {


    fun lightChange() {
        if (currentLight == "Red") {
            currentLight = "Green"

        } else if (currentLight == "Green") {
            currentLight = "Yellow"
        } else {
            currentLight = "Red"
        }
        println(currentLight)
    }

}


fun main(args: Array<String>) {
    var gLight = TrafficLight("Green")
    var yLight = TrafficLight("Yellow")
    var rLight = TrafficLight("Red")

    gLight.lightChange()
    yLight.lightChange()
    rLight.lightChange()
}
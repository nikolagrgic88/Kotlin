fun main() {

    val listNames = arrayOf("Athlete 1", "Athlete 2", "Athlete 3", "Athlete 4")
    val athletesTime = arrayOf(1.2516, 1.3568, 0.1254, 0.000)

    rankAthletes(listNames, athletesTime)
}


fun rankAthletes(names: Array<String>, times: Array<Double>) {
    var sorted = true

    while (sorted) {
        sorted = false

        for (i in 0..<(times.size - 1)) {

            if (times[i] > times[i + 1]) {
                val tempTime = times[i]
                val tempPos = names[i]
                //swap athletes
                names[i] = names[i + 1]
                names[i + 1] = tempPos
                //swap times
                times[i] = times[i + 1]
                times[i + 1] = tempTime
                sorted = true
            }
        }
    }
    for (i in names.indices) {
        println("${names[i]}: +${times[i]}")
    }


}
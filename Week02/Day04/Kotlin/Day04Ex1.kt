class Pet(
    var name: String,
    var nicknames: Array<String> = arrayOf(),
    var age: Int,
    var species: String,
    var sleeping: Boolean
) {


    fun addNickname(nickName: String) {
        if (nicknames.size < 4) {
            nicknames = nicknames.plus(nickName)
        } else {
            println("Your pat already has 4 nicknames")
        }

    }

    fun birthday() {
        age++
        println("$name is $age years old")
    }

    fun sleep() {
        sleeping = !sleeping
    }

    fun isSleeping(): Boolean {
        if (sleeping)
            println("$name is sleeping")
        else println("$name is awake")
        return sleeping
    }
}

fun main() {
    val dog = Pet("Jacky", arrayOf("Bluey"), 5, "dog", true)
    val cat = Pet("Nala", arrayOf("Bella"), 10, "cat", false)

    dog.addNickname("jacky")
    dog.birthday()
    dog.sleep()
    dog.isSleeping()
    dog.sleep()
    dog.isSleeping()

    cat.addNickname("tiger")
    cat.birthday()
    cat.sleep()
    cat.isSleeping()

}
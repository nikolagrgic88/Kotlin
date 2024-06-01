class Player(var name: String) {
    var nextPlayer: Player? = null
}

fun main() {
    val player1 = Player("Jeff")
    val player2 = Player("Alex")
    val player3 = Player("Alice")
    val player4 = Player("Lauren")

    player1.nextPlayer = player2
    player2.nextPlayer = player3
    player3.nextPlayer = player4
    player4.nextPlayer = player1

    var passes = readlnOrNull()?.toInt()
    var counter = 0
    var previousPlayer: Player? = null
    var currentPlayer = player1
    val hotPot = (2..50).random()
    println("${currentPlayer.name} has a potato")

    while (counter < hotPot) {
        for (i in 0..passes!!.toInt()) {
            if (counter < hotPot) {
                counter++
                previousPlayer = currentPlayer
                currentPlayer = currentPlayer.nextPlayer!!
                println("${previousPlayer.name} passed it to ${currentPlayer.name}")
            } else break
        }

        println("${currentPlayer.name} has the potato.")

        if (counter >= hotPot) {
            println("The potato was really hot and ${currentPlayer.name} dropped it!")
            break
        }
        passes = readlnOrNull()?.toInt()
    }


}
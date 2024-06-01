fun main() {

    val grid = Array(3) { IntArray(3) }
    var gamePlayed = 0
    var player = true
    println("Lets Play Tic-Tac-Toe ")

    while (gamePlayed <= 8) {

        if (player) {
            println("Player X your turn!")
        } else {
            println("Player O your turn!")
        }
        val userInput = readln()
//        splitting string and removing first and last empty element
        var userInt = userInput.split("").filter { it.isNotEmpty() }
        var x = userInt[0].toInt()
        var y = userInt[1].toInt()

//        if invalid input
        if (userInput == " " || userInput.length != 2 || x < 0 || x >= 3 || y < 0 || y >= 3) {
            println("Invalid input. Please try again")
            continue
        }

//        If the cell is already taken
        if (grid[x][y] != 0) {
            println("Cell already taken. Please choose another position.")
            continue
        }

//         populating an array - 1 for X, 2 for O
        if (player) {
            grid[x][y] = 1
        } else {
            grid[x][y] = 2
        }

//        drawing a grid
        for (nums in grid) {
            print("\n")
            for (num in nums) if (num == 1) {
                print("| X |")
            } else if (num == 2) {
                print("| O |")
            } else {
                print("| - |")
            }
        }
        print("\n")

//        Checking if there is a winner
        if (checkingWinner(grid, player)) return //if true finish the game

        gamePlayed++
        player = !player // switching players

    }
    println("Its a Draw!")
}


fun checkingWinner(grid: Array<IntArray>, player: Boolean): Boolean {
    val winnerX = "Player X is the WINNER"
    val winnerO = "Player O is the WINNER"

//        Checking if there is a winner
    for (i in 0..2) {
//        checking rows
        if (grid[i][0] != 0 && grid[i][0] == grid[i][1] && grid[i][1] == grid[i][2]) {
            if (player) println(winnerX) else println(winnerO)
            return true
        }
//        checking columns
        if (grid[0][i] != 0 && grid[0][i] == grid[1][i] && grid[1][i] == grid[2][i]) {
            if (player) println(winnerX) else println(winnerO)
            return true
        }
//        checking diagonal
        if (grid[0][0] != 0 && grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2]) {
            if (player) println(winnerX) else println(winnerO)
            return true
        }
//        checking diagonal
        if (grid[0][2] != 0 && grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0]) {
            if (player) println(winnerX) else println(winnerO)
            return true
        }
    }
    return false // if there is no winner
}

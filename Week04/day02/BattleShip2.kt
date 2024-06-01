import kotlin.math.abs

var gridPlayerOne = Array(10) { IntArray(10) }
var gridPlayerTwo = Array(10) { IntArray(10) }


fun main() {
    setUp()
    play()
}

fun play() {
    var playerOneMove = true

    while (true) {

        val currentPlayerGrid = if (playerOneMove) gridPlayerTwo else gridPlayerOne
        val currentPlayerName = if (playerOneMove) "Player One" else "Player Two"

        println("$currentPlayerName:")


        var spl = readln().split(" ").filter { it.isNotEmpty() }
        while (spl.size != 2) {
            println("Incorrect input, please try again")
            spl = readln().split(" ").filter { it.isNotEmpty() }
        }

        val a = spl[0].toInt()
        val b = spl[1].toInt()

        // checking if input is in boundaries
        if (a < 0 || a > 9 || b < 0 || b > 9) {
            println("Invalid input. Please try again")
            continue
        }
        if (currentPlayerGrid[a][b] != 0) {
            currentPlayerGrid[a][b] = 9
            println("💥YOU HIT💥")
            printGrid(currentPlayerGrid)
        } else {
            println("YOU MISSED")
            currentPlayerGrid[a][b] = 8
            printGrid(currentPlayerGrid)
        }
        var allZeros = true
        //checking if all cells are zero
        for (row in currentPlayerGrid) {
            for (cell in row) {
                //checking for 0 and 9(hits)
                if (cell != 0 && cell != 9) {
                    allZeros = false
                    break
                }
            }
            //if its still true
            if (!allZeros) {
                break
            }
        }
        if (allZeros) {
            println("$currentPlayerName wins!")
            break
        }
        playerOneMove = !playerOneMove
    }
}

fun setUp() {

    val players = listOf("Player One", "Player Two")
    val grids = listOf(gridPlayerOne, gridPlayerTwo)
    //setting up grids
    for (i in 0..<2) {
        println("${players[i]} set your battleships! ")
        val shipTypes =
            arrayListOf(2 to "Patrol Boat", 3 to "Submarine", 3 to "Destroyer", 4 to "Battleship", 5 to "Carrier")

        for (ship in shipTypes) {
            println("${ship.second} ${ship.first} spaces \n Beginning coordinates: ")


            var begSplit = readln().split(" ").filter { it.isNotEmpty() }
            while (begSplit.size != 2) {
                println("Incorrect input, please try again!")
                begSplit = readln().split(" ").filter { it.isNotEmpty() }
            }

            val a = begSplit[0].toInt()
            val b = begSplit[1].toInt()

            println("End coordinates: ")

            var endSplit = readln().split(" ").filter { it.isNotEmpty() }
            while (endSplit.size != 2) {
                println("Incorrect input, please try again!")
                endSplit = readln().split(" ").filter { it.isNotEmpty() }
            }

            val x = endSplit[0].toInt()
            val y = endSplit[1].toInt()

            if (x < 0 || x > 9 || y < 0 || y > 9 || a < 0 || a > 9 || b < 0 || b > 9 || begSplit.size != 2 || endSplit.size != 2) {
                println("Invalid input. Please try again")
                continue
            }

            if (grids[i][a][b] != 0 || grids[i][x][y] != 0) {
                println("Cell already taken. Please choose another position.")
                continue
            }

            //adding coordinates to arrays
            if ((b == y && (abs(a - x) + 1) == ship.first) || (a == x && (abs(b - y)) + 1 == ship.first)) {
//
                if (b == y && (abs(a - x) + 1) == ship.first) {
                    val increment = if (a > x) -1 else 1
                    for (v in 0..<ship.first) {
                        grids[i][a + v * increment][b] = ship.first
                    }
                } else if (a == x && (abs(b - y) + 1) == ship.first) {
                    val increment = if (b > y) -1 else 1
                    for (v in 0..<ship.first) {
                        grids[i][a][b + v * increment] = ship.first
                    }
                } else {
                    println("Your ship has the wrong length or coordinates")
                    continue
                }
            }
        }
        printGrid(grids[i])
    }
}


fun printGrid(grid: Array<IntArray>) {
    println("  0  1 2 3 4  5 6 7 8 9")
    for (i in grid.indices) {
        print("$i ")
        for (j in 0..<grid[i].size) {
            print(if (grid[i][j] == 0 || grid[i][j] != 9) "🟦" else if (grid[i][j] == 8) "❌" else "💥")
        }
        println()
    }
}



fun main (args: Array<String>) {
    gameLoop()
}

fun gameLoop() {
    println("Welcome to kotlin tic tac toe!")

    makeMoveLoop(Board())
}

fun makeMove(board: Board): Board {
    while(true) {
        println("Make move for player ${board.getNextPlayer()} with format: x y")
        val (a, b) = readLine()!!.split(' ')
        println("${a.toInt()}  ${b.toInt()}")
        try {
            return board.makeMove(a.toInt(), b.toInt())
        } catch (e: InvalidMoveException) {
            println(e.message)
        }
    }
}

fun makeMoveLoop(board: Board): Board {
    println(board)

    // is game over?
    if (board.isTie()){
        println("Game ends in tie!")
        return board
    }
    if (board.hasPlayerWon(board.playerOneKey)) {
        println("Player ${board.playerOneKey} has won!")
        return board
    }
    if (board.hasPlayerWon(board.playerTwoKey)) {
        println("Player ${board.playerTwoKey} has won!")
        return board
    }

    // make move
    return makeMoveLoop(makeMove(board))
}

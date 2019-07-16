
fun main (args: Array<String>) {
//    print("hello world")
//    val board = Board()
//////    println(board)
//////
//////    val move1 = board.makeMove(0, 0, 'X')
//////    println(move1)
//////
//////    val move2 = move1.makeMove(1, 0, 'O')
//////    println(move2)
//////
//////    val move3 = move2.makeMove(2, 0, 'X')
//////    println(move3)
//////
//////    val move4 = move3.makeMove(0, 1, 'O')
//////    println(move4)
//////
//////    val move5 = move4.makeMove(2, 2, 'X')
//////    println(move5)
//////
//////    // Illegal move
////////    val move6 = move5.makeMove(3, 2, 'X')
////////    println(move6)

    gameLoop()

}

fun gameLoop() {
    println("Welcome to kotlin tic tac toe!")

    makeMoveLoop(Board())
}

fun makeMove(board: Board): Board {
    val (a, b) = readLine()!!.split(' ')
    println("${a.toInt()}  ${b.toInt()}")
    return board.makeMove(a.toInt(), b.toInt())
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
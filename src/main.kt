
fun main (args: Array<String>) {
    print("hello world")
    val board = Board()
    println(board)

    val move1 = board.makeMove(0, 0, 'X')
    println(move1)

    val move2 = move1.makeMove(1, 0, 'O')
    println(move2)

    val move3 = move2.makeMove(2, 0, 'X')
    println(move3)

    val move4 = move3.makeMove(0, 1, 'O')
    println(move4)

    val move5 = move4.makeMove(2, 2, 'X')
    println(move5)

    // Illegal move
//    val move6 = move5.makeMove(3, 2, 'X')
//    println(move6)
    
}
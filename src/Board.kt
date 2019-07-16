class Board(var boardState : List<Char?> = listOf(null, null, null, null, null, null, null, null, null)) {
    val playerOneKey = 'X'
    val playerTwoKey = 'Y'

    override fun toString(): String {
        return """


             ${boardState[0] ?: " "} | ${boardState[1] ?: " "} | ${boardState[2] ?: " "}
            -----------
             ${boardState[3] ?: " "} | ${boardState[4] ?: " "} | ${boardState[5] ?: " "}
            -----------
             ${boardState[6] ?: " "} | ${boardState[7] ?: " "} | ${boardState[8] ?: " "}
        """.trimIndent()
    }

    fun makeMove(x: Int, y: Int, playerKey: Char): Board {
        // is this an insane way to do exception checking....?
        when {
            (x < 0 || x > 2 || y < 0 || y > 2) -> throw InvalidMoveException("Illegal move out of bounds $x $y")
            stateAt(x, y) != null -> throw InvalidMoveException("Space $x $y already has move ${stateAt(x, y)}")
            hasPlayerWon(playerOneKey) -> GameOverException("Game over because $playerOneKey won")
            hasPlayerWon(playerTwoKey) -> GameOverException("Game over because $playerTwoKey won")
            isTie() -> GameOverException("Game over because tie")
        }

        return Board(boardState.mapIndexed { i, it -> if (i == coordToPos(x, y)) playerKey else it })
    }

    fun isOver() = hasPlayerWon(playerOneKey) || hasPlayerWon(playerTwoKey) || isTie()

    fun hasPlayerWon(playerKey: Char): Boolean {
        return WINNING_STATES.any {
                winningState -> winningState.withIndex().all { (idx, v)  ->  !v || boardState[idx] == playerKey }
        }
    }

    fun isTie() = boardState.all { it != null }

    fun coordToPos(x: Int, y: Int) = y * 3 + x

    fun stateAt(x: Int, y: Int) = boardState[coordToPos(x, y)]

}

val WINNING_STATES : List<List<Boolean>> = listOf(
    listOf(true, true, true, false, false, false, false, false, false),
    listOf(false, false, false, true, true, true, false, false, false),
    listOf(false, false, false, false, false, false, true, true, true),
    listOf(true, false, false, true, false, false, true, false, false),
    listOf(false, true, false, false, true, false, false, true, false),
    listOf(false, false, true, false, false, true, false, false, true),
    listOf(true, false, false, false, true, false, false, false, true),
    listOf(false, false, true, false, true, false, true, false, false)

)

class InvalidMoveException(message:String): Exception(message)
class GameOverException(message: String): Exception(message)
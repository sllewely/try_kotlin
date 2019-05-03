
class Board(var boardState : List<Char?> = listOf(null, null, null, null, null, null, null, null, null)) {

    override fun toString(): String {
        return """


             ${boardState[0] ?: " "} | ${boardState[1] ?: " "} | ${boardState[2] ?: " "}
            -----------
             ${boardState[3] ?: " "} | ${boardState[4] ?: " "} | ${boardState[5] ?: " "}
            -----------
             ${boardState[6] ?: " "} | ${boardState[7] ?: " "} | ${boardState[8] ?: " "}
        """.trimIndent()
    }

}
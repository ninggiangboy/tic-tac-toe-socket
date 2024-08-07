class TicTacToeView {
    fun printBoard(board: Array<CharArray>) {
        val separator = "+---+---+---+"
        println(separator)
        for (row in board) {
            println("| ${row.joinToString(" | ")} |")
            println(separator)
        }
    }

    fun displayMessage(message: String) {
        println(message)
    }

    fun getUserInput(prompt: String): String {
        print(prompt)
        return readlnOrNull() ?: ""
    }
}
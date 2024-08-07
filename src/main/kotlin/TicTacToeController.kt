class TicTacToeController(private val model: TicTacToeBoard, private val view: TicTacToeView) {
    fun playGame(networkPlayer: NetworkPlayer) {
        var gameOver = false

        while (!gameOver) {
            view.printBoard(model.getBoard())
            if (model.currentPlayer == networkPlayer.symbol) {
                val input = view.getUserInput("Your turn (enter row and column, e.g., '1 2'): ")
                val (row, col) = input.split(" ").map { it.toInt() - 1 }
                if (model.makeMove(row, col)) {
                    networkPlayer.sendMove(row, col)
                } else {
                    view.displayMessage("Invalid move, try again.")
                    continue
                }
            } else {
                view.displayMessage("Waiting for opponent's move...")
                val (row, col) = networkPlayer.getMove()
                model.makeMove(row, col)
            }

            val winner = model.checkWinner()
            if (winner != ' ') {
                view.printBoard(model.getBoard())
                when (winner) {
                    'X' -> view.displayMessage("X wins!")
                    'O' -> view.displayMessage("O wins!")
                    'D' -> view.displayMessage("It's a draw!")
                }
                gameOver = true
            }
        }
    }
}
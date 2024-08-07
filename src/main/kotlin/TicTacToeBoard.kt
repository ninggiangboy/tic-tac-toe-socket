class TicTacToeBoard {
    private val board = Array(3) { CharArray(3) { ' ' } }
    var currentPlayer = 'X'
        private set

    fun makeMove(row: Int, col: Int): Boolean {
        if (row !in 0..2 || col !in 0..2 || board[row][col] != ' ') {
            return false
        }
        board[row][col] = currentPlayer
        currentPlayer = if (currentPlayer == 'X') 'O' else 'X'
        return true
    }

    fun checkWinner(): Char {
        // Check rows and columns
        for (i in 0..2) {
            if (board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return board[i][0]
            }
            if (board[0][i] != ' ' && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                return board[0][i]
            }
        }
        // Check diagonals
        if (board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return board[0][0]
        }
        if (board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return board[0][2]
        }
        // Check for draw
        if (board.all { row -> row.all { it != ' ' } }) {
            return 'D'
        }
        return ' '
    }

    fun getBoard(): Array<CharArray> = board.map { it.clone() }.toTypedArray()
}
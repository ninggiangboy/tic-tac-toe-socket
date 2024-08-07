import java.net.ServerSocket
import java.net.Socket

fun main() {
    val view = TicTacToeView()
    val choice = view.getUserInput("Enter 1 to host a game, 2 to join a game: ").toInt()

    val model = TicTacToeBoard()
    val controller = TicTacToeController(model, view)
    val player: NetworkPlayer

    if (choice == 1) {
        view.displayMessage("Waiting for opponent to connect...")
        val serverSocket = ServerSocket(50000)
        val clientSocket = serverSocket.accept()
        player = NetworkPlayer(clientSocket, 'O')
        view.displayMessage("Opponent connected!")
    } else {
        val hostIp = view.getUserInput("Enter the host's IP address: ")
        val socket = Socket(hostIp, 50000)
        player = NetworkPlayer(socket, 'X')
        view.displayMessage("Connected to the host!")
    }

    controller.playGame(player)
    player.close()
}
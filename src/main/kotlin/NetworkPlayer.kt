import java.io.PrintWriter
import java.net.Socket
import java.util.*

class NetworkPlayer(private val socket: Socket, val symbol: Char) {
    private val input = Scanner(socket.getInputStream())
    private val output = PrintWriter(socket.getOutputStream(), true)

    fun sendMove(row: Int, col: Int) {
        output.println("$row $col")
    }

    fun getMove(): Pair<Int, Int> {
        val move = input.nextLine().split(" ")
        return Pair(move[0].toInt(), move[1].toInt())
    }

    fun close() {
        socket.close()
    }
}

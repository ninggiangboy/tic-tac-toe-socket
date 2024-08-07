# Networked Tic-Tac-Toe Game

This project implements a networked version of the classic Tic-Tac-Toe game in Kotlin, utilizing client-server architecture over sockets.

## How to Run

1. Setup: 

- Ensure you have JDK (Java Development Kit) installed to compile and run Kotlin code.

3. Compile and Run:

- Clone or download the repository to your local machine.
- Open the project in your preferred Kotlin IDE (e.g., IntelliJ IDEA, Android Studio).
- Compile and run the main function in TicTacToe.kt to start the game.

## How to Play

1. Start the Game:

- Upon running the program, you will be prompted to choose whether to host a game or join a game by entering `1` or `2`, respectively.

2. Hosting a Game:

- If you choose to host `1`, the program will listen for incoming connections on port `5000`.
- Once a client connects, the game begins. You will see a message indicating the opponent has connected.

3. Joining a Game:

- If you choose to join `2`, you will be prompted to enter the IP address of the host (`0.0.0.0` or `localhost` if you want to test this game in same computer)
- Once connected, the game starts.

4. Gameplay:

- Players take turns making moves by entering the row and column (e.g., `1 2` for the first row, second column).
- The game alternates turns between `X` and `O`.
- The game ends when a player wins, there is a draw, or a player disconnects.

5. End of Game:

- After the game ends, the program closes the connection and allows you to start a new game if desired.
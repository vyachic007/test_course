package by.slava_borisov.hangman;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner  scanner = new Scanner(System.in);
        GameLogic gameLogic = new GameLogic();
        GameDisplay gameDisplay = new GameDisplay();

        gameDisplay.showWelcomeMessage();

        GameState currentGame = gameLogic.initGame();


        while (!gameLogic.isGameOver(currentGame)) {
            gameDisplay.showCurrentState(currentGame);
            gameDisplay.showRemainingLives(currentGame);
            gameDisplay.showUsedLetters(currentGame);

            System.out.print("\nВведите букву: ");
            char letter = scanner.nextLine().charAt(0);

            gameLogic.processGuess(currentGame, letter);
        }

        boolean won = gameLogic.isGameWon(currentGame);
        gameDisplay.showResult(currentGame, won);
    }
}

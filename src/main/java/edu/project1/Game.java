package edu.project1;

import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;

public class Game {
    private Dictionary dictionary;
    private GameManager gameManager;
    private boolean isGameStopped;

    public Game(Reader dictionaryReader) throws IOException {
        dictionary = new Dictionary(dictionaryReader);
        gameManager = new GameManager(dictionary.getRandomWord(), dictionary.getRandomWordLength());
        isGameStopped = false;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        char enteredLetter;
        boolean hit;
        String command;

        while (!gameManager.isPlayerWon() && (gameManager.getAttempts() != gameManager.getMaxAttempts())
            && !isGameStopped) {
            System.out.println("Guess a letter:");
            command = scanner.nextLine();
            if (!isCharacterEntered(command)) {
                continue;
            }
            enteredLetter = command.charAt(0);
            hit = gameManager.guess(enteredLetter);

            if (hit) {
                System.out.println("Hit!");
            } else {
                System.out.printf(
                    "Missed, mistake %d out of %d.\n",
                    gameManager.getAttempts(),
                    gameManager.getMaxAttempts()
                );
            }
            System.out.printf("The word: %s\n", gameManager.getUserAnswer());
        }
        if (isGameStopped) {
            System.out.println("The game is stopped.");
        } else {
            if (gameManager.isPlayerWon()) {
                System.out.println("You won!");
                System.out.printf("Total attempts: %d\n", gameManager.getAttempts());
            } else {
                System.out.println("You lost!");
            }

        }
    }

    private boolean isCharacterEntered(String command) {
        if (command.equals("stop")) {
            isGameStopped = true;
            return false;
        } else {
            return command.length() == 1;
        }
    }
}

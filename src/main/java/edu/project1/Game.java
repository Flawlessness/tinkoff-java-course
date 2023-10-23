package edu.project1;

import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Game {
    private final static Logger LOGGER = LogManager.getLogger();
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
            LOGGER.info("Guess a letter:");
            command = scanner.nextLine();
            if (!isCharacterEntered(command)) {
                continue;
            }
            enteredLetter = command.charAt(0);
            hit = gameManager.guess(enteredLetter);

            if (hit) {
                LOGGER.info("Hit!");
            } else {
                LOGGER.info(
                    "Missed, mistake {} out of {}.",
                    gameManager.getAttempts(),
                    gameManager.getMaxAttempts()
                );
            }
            LOGGER.info("The word: {}", gameManager.getUserAnswer());
        }
        if (isGameStopped) {
            LOGGER.info("The game is stopped.");
        } else {
            if (gameManager.isPlayerWon()) {
                LOGGER.info("You won!");
                LOGGER.info("Total attempts: {}", gameManager.getAttempts());
            } else {
                LOGGER.info("You lost!");
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

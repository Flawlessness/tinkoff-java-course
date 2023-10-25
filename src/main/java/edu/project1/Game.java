package edu.project1;

import java.io.Reader;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Game {
    private final static Logger LOGGER = LogManager.getLogger();
    private Dictionary dictionary;
    private GameManager gameManager;

    public Game(Reader dictionaryReader) {
        dictionary = new Dictionary(dictionaryReader);
        gameManager = new GameManager(dictionary.getRandomWord(), dictionary.getRandomWordLength());
    }

    public void run() {
        if (!gameManager.isAnswerCorrect()) {
            LOGGER.info("Incorrect format of the guessed word.");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        String enteredString;
        int returnCode;

        while (!gameManager.isPlayerWon() && (gameManager.getAttempts() != gameManager.getMaxAttempts())
            && !gameManager.isGameStopped()) {
            LOGGER.info("Guess a letter:");
            enteredString = scanner.nextLine();

            returnCode = gameManager.guess(enteredString);
            if (returnCode == -1) {
                continue;
            }

            if (returnCode == 1) {
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
        if (gameManager.isGameStopped()) {
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
}

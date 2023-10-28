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
        gameManager = new GameManager(dictionary.getRandomWord());
    }

    public void run() {
        if (!gameManager.isAnswerCorrect()) {
            LOGGER.info("Incorrect format of the guessed word.");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        String enteredString;
        ReturnCode returnCode = null;

        while (!gameManager.isPlayerWon() && (gameManager.getAttempts() != gameManager.getMaxAttempts())) {
            LOGGER.info("Guess a letter:");
            enteredString = scanner.nextLine();

            returnCode = gameManager.guess(enteredString);
            if (returnCode == ReturnCode.ERROR) {
                continue;
            }

            if (returnCode == ReturnCode.STOP) {
                break;
            }

            if (returnCode == ReturnCode.HIT) {
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
        if (returnCode == ReturnCode.STOP) {
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

    public enum ReturnCode {
        STOP,
        HIT,
        MISS,
        ERROR
    }
}

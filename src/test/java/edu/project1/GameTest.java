package edu.project1;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameTest {
    @Test
    @DisplayName("Checking the change in the number of attempts in case of an incorrect answer")
    void incorrectAnswerAttemptsTest() {
        String randomWord = "b";
        GameManager gameManager = new GameManager(randomWord, randomWord.length());

        gameManager.guess("a");

        assertThat(gameManager.getAttempts()).isEqualTo(1);
    }

    @Test
    @DisplayName("Checking the change in the number of attempts in case of a correct answer")
    void correctAnswerAttemptsTest() {
        String randomWord = "b";
        GameManager gameManager = new GameManager(randomWord, randomWord.length());

        gameManager.guess("b");

        assertThat(gameManager.getAttempts()).isEqualTo(1);
    }

    @Test
    @DisplayName("Checking that the game state does not change if the character is entered incorrectly")
    void incorrectCharacterTest() {
        String randomWord = "ab";
        GameManager gameManager = new GameManager(randomWord, randomWord.length());

        gameManager.guess("ab");

        assertThat(gameManager.getAttempts()).isEqualTo(0);
        assertThat(gameManager.getUserAnswer()).isEqualTo("**");
    }

    @Test
    @DisplayName("Checking the player's winnings when guessing all the letters")
    void playerWonTest() {
        String randomWord = "ab";
        GameManager gameManager = new GameManager(randomWord, randomWord.length());

        gameManager.guess("b");
        gameManager.guess("a");

        assertThat(gameManager.isPlayerWon()).isEqualTo(true);
    }

    @Test
    @DisplayName("Checking the correct change of the game state with the correct answer")
    void gameStateCorrectAnswerTest() {
        String randomWord = "ab";
        GameManager gameManager = new GameManager(randomWord, randomWord.length());

        gameManager.guess("b");

        assertThat(gameManager.getUserAnswer()).isEqualTo("*b");
    }
    @Test
    @DisplayName("Checking the correct change of the game state in case of an incorrect answer")
    void gameStateIncorrectAnswerTest() {
        String randomWord = "ab";
        GameManager gameManager = new GameManager(randomWord, randomWord.length());

        gameManager.guess("c");

        assertThat(gameManager.getUserAnswer()).isEqualTo("**");
    }

    @Test
    @DisplayName("Checking the correct format of the guessed word")
    void correctFormatRandomWordTest() {
        String randomWord = "";
        GameManager gameManager = new GameManager(randomWord, 0);

        assertThat(gameManager.isAnswerCorrect()).isEqualTo(false);
    }

    @Test
    @DisplayName("Checking that the player loses when the maximum number of attempts is reached")
    void playerLoseTest() {
        String randomWord = "a";
        GameManager gameManager = new GameManager(randomWord, randomWord.length());

        gameManager.guess("b");
        gameManager.guess("c");

        assertThat(gameManager.isPlayerWon()).isEqualTo(false);
        assertThat(gameManager.getAttempts()).isEqualTo(randomWord.length()*2);
    }

    @Test
    @DisplayName("Checking that the game is stopped by the \"stop\" command")
    void stopGameTest() {
        String randomWord = "a";
        GameManager gameManager = new GameManager(randomWord, randomWord.length());

        gameManager.guess("b");
        gameManager.guess("stop");

        assertThat(gameManager.isGameStopped()).isEqualTo(true);
    }

}

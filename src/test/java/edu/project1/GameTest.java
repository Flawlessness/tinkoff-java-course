package edu.project1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.Reader;
import java.io.StringReader;

public class GameTest {
    @Test
    @DisplayName("Exceeding the maximum number of attempts")
    void maximumNumberAttemptsTest() throws IOException {
        String userInput = """
            b
            b
            """;
        String dictionary = """
            1
            a
            """;
        Reader dictionaryReader = new StringReader(dictionary);
        InputStream is = new ByteArrayInputStream(userInput.getBytes());
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);

        System.setIn(is);
        System.setOut(ps);
        Game game = new Game(dictionaryReader);
        game.run();
        System.out.flush();

        String[] output = baos.toString().split("\n");
        Assertions.assertEquals("You lost!", output[output.length - 1]);
    }

    @Test
    @DisplayName("Checking correct operation")
    void correctOperationTest() throws IOException {
        String userInput = """
            a
            b
            f
            l
            o
            w
            """;
        String dictionary = """
            1
            flow
            """;
        Reader dictionaryReader = new StringReader(dictionary);
        InputStream is = new ByteArrayInputStream(userInput.getBytes());
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);

        System.setIn(is);
        System.setOut(ps);
        Game game = new Game(dictionaryReader);
        game.run();
        System.out.flush();

        String[] output = baos.toString().split("\n");
        Assertions.assertEquals("Total attempts: 6", output[output.length - 1]);
    }

    @Test
    @DisplayName("Same input letters")
    void sameLettersTest() throws IOException {
        String userInput = """
            h
            h
            e
            """;
        String dictionary = """
            1
            he
            """;
        Reader dictionaryReader = new StringReader(dictionary);
        InputStream is = new ByteArrayInputStream(userInput.getBytes());
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);

        System.setIn(is);
        System.setOut(ps);
        Game game = new Game(dictionaryReader);
        game.run();
        System.out.flush();

        String[] output = baos.toString().split("\n");
        Assertions.assertEquals("Total attempts: 3", output[output.length - 1]);
    }

    @Test
    @DisplayName("Invalid input")
    void invalidInputTest() throws IOException {
        String userInput = """
            abc
            b
            e
            """;
        String dictionary = """
            1
            be
            """;
        Reader dictionaryReader = new StringReader(dictionary);
        InputStream is = new ByteArrayInputStream(userInput.getBytes());
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);

        System.setIn(is);
        System.setOut(ps);
        Game game = new Game(dictionaryReader);
        game.run();
        System.out.flush();

        String[] output = baos.toString().split("\n");
        Assertions.assertEquals("Total attempts: 2", output[output.length - 1]);
    }

    @Test
    @DisplayName("Stop command")
    void stopCommandTest() throws IOException {
        String userInput = """
            a
            stop
            """;
        String dictionary = """
            1
            abc
            """;
        Reader dictionaryReader = new StringReader(dictionary);
        InputStream is = new ByteArrayInputStream(userInput.getBytes());
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);

        System.setIn(is);
        System.setOut(ps);
        Game game = new Game(dictionaryReader);
        game.run();
        System.out.flush();

        String[] output = baos.toString().split("\n");
        Assertions.assertEquals("The game is stopped.", output[output.length - 1]);
    }
}

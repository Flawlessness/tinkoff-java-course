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
    @DisplayName("Checking correct operation")
    void correctOperationTest() throws IOException {
        String userInput = """
            a
            b
            b
            abb
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
        Assertions.assertEquals(" \u001B[32mTotal attempts: 7\u001B[m", output[output.length - 1].split("--")[1]);
    }

}

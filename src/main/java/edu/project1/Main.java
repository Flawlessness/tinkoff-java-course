package edu.project1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Main {
    private final static Logger LOGGER = LogManager.getLogger();

    private Main() {
    }

    public static void main(String[] args) throws FileNotFoundException {
        FileReader dictionary = new FileReader("src/main/resources/dictionary");
        Game game = new Game(dictionary);
        game.run();
    }
}


package edu.project1;

import java.io.Reader;
import java.util.Random;
import java.util.Scanner;

public class Dictionary {
    private final Random random = new Random();
    private String randomWord;
    private final Reader dictionaryReader;

    public Dictionary(Reader dictionaryReader) {
        this.dictionaryReader = dictionaryReader;
    }

    public String getRandomWord() {
        int numberAvailableWords;
        Scanner dictionaryScanner = new Scanner(dictionaryReader);
        numberAvailableWords = Integer.parseInt(dictionaryScanner.nextLine());
        int wordNumber = random.nextInt(numberAvailableWords) + 1;
        for (int i = 0; i < wordNumber; i++) {
            randomWord = dictionaryScanner.nextLine();
        }
        return randomWord;
    }

}

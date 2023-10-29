package edu.hw3;

import java.util.ArrayList;
import java.util.List;

public class Task2 {
    private Task2() {
    }

    public static List<String> clusterize(String brackets) {

        List<String> clusterized = new ArrayList<>();

        int openedBrackets = 0;
        StringBuilder clusterBuilder = new StringBuilder();

        for (int pos = 0; pos < brackets.length(); pos++) {

            char bracket = brackets.charAt(pos);
            clusterBuilder.append(bracket);

            openedBrackets = switch (bracket) {
                case '(' -> openedBrackets + 1;
                case ')' -> openedBrackets - 1;
                default -> throw new IllegalArgumentException("Unexpected value: " + bracket);
            };

            if (openedBrackets == 0) {
                clusterized.add(clusterBuilder.toString());
                clusterBuilder = new StringBuilder();

            } else if (openedBrackets < 0) {
                throw new IllegalArgumentException("Too many closing brackets!");
            }
        }

        if (openedBrackets != 0) {
            throw new IllegalArgumentException("Bad input");
        }

        return clusterized;
    }

}

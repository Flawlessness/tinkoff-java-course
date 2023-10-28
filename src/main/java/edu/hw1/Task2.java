package edu.hw1;

public class Task2 {
    private final static int BASE = 10;

    private Task2() {
    }

    public static int countDigits(int number) {
        int count = 0;
        int num = number;
        do {
            count++;
            num /= BASE;
        } while (num != 0);
        return count;
    }
}

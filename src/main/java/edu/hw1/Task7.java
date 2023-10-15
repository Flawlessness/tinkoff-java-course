package edu.hw1;

public class Task7 {
    private Task7() {
    }

    public static int rotateLeft(int n, int shift) {
        int positionFirstDigit = 0;
        int number = n;
        while ((number >> positionFirstDigit) != 0) {
            positionFirstDigit++;
        }
        int firstDigit = 1 << positionFirstDigit;
        int firstDigitInvert = ~firstDigit;
        for (int j = 0; j < shift; j++) {
            number = number << 1;
            if ((number & firstDigit) != 0) {
                number = number | 1;
                number = number & firstDigitInvert;
            }
        }
        return number;
    }

    public static int rotateRight(int n, int shift) {
        int positionFirstDigit = 0;
        int number = n;
        while ((n >> positionFirstDigit) != 0) {
            positionFirstDigit++;
        }
        int firstDigit = 1 << (positionFirstDigit - 1);

        for (int j = 0; j < shift; j++) {
            if ((number & 1) == 1) {
                number >>= 1;
                number |= firstDigit;
            } else {
                number >>= 1;
            }
        }
        return number;
    }
}

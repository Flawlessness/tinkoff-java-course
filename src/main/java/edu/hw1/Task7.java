package edu.hw1;

public class Task7 {
    private Task7() {
    }

    public static int binaryNumberLength(int number) {
        int length = 0;
        while ((number >> length) != 0) {
            length++;
        }
        return length;
    }

    public static int rotateLeft(int n, int shift) {
        int number = n;
        int positionFirstDigit = binaryNumberLength(n);
        int firstDigit = 1 << positionFirstDigit;
        int firstDigitInvert = ~firstDigit;

        if (number == 0) {
            return number;
        }

        int shiftChanged = shift;
        shiftChanged %= positionFirstDigit;

        for (int j = 0; j < shiftChanged; j++) {
            number = number << 1;
            if ((number & firstDigit) != 0) {
                number = number | 1;
                number = number & firstDigitInvert;
            }
        }
        return number;
    }

    public static int rotateRight(int n, int shift) {
        int number = n;
        int positionFirstDigit = binaryNumberLength(n);
        int firstDigit = 1 << (positionFirstDigit - 1);

        if (number == 0) {
            return number;
        }

        int shiftChanged = shift;
        shiftChanged %= positionFirstDigit;

        for (int j = 0; j < shiftChanged; j++) {
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

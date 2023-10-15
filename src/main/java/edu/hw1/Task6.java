package edu.hw1;

import java.util.Arrays;

public class Task6 {

    public static final int MAX = 9999;
    public static final int MIN = 1000;
    public static final int BASE = 10;
    public static final int RES = 6174;

    private Task6() {
    }

    public static void reverse(char[] array) {
        int i = 0;
        int j = array.length - 1;
        while (i < j) {
            char temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }
    }

    public static int countK(int number) {
        if ((number > MAX) || (number <= MIN) // последнее условие отвечает, за отсуствие одинаковых цифр
            || ((number / (BASE * BASE) - number % (BASE * BASE)) == 0)) {
            return -1;
        }

        if (number == RES) {
            return 0;
        }

        String numberStr = Integer.toString(number);

        char[] ascendingChars = numberStr.toCharArray();
        char[] descendingChars = numberStr.toCharArray();

        Arrays.sort(ascendingChars);
        System.arraycopy(ascendingChars, 0, descendingChars, 0, ascendingChars.length);
        reverse(descendingChars);

        int ascending = Integer.parseInt(new String(ascendingChars));
        int descending = Integer.parseInt(new String(descendingChars));

        int difference = descending - ascending;

        if (difference < MIN) {
            difference *= BASE;
        }

        return countK(difference) + 1;
    }
}

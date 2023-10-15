package edu.hw1;

public class Task3 {
    private Task3() {
    }

    public static boolean isNestable(int[] array1, int[] array2) {
        if ((array1 == null) || (array2 == null)) {
            throw new IllegalArgumentException("array1 or array2 is null");
        }

        if ((array1.length == 0) || (array2.length == 0)) {
            return false; // если max/min нету, то условие не может быть выполнено
        }

        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for (int i : array1) {
            if (i < min1) {
                min1 = i;
            }
            if (i > max1) {
                max1 = i;
            }
        }

        for (int i : array2) {
            if (i < min2) {
                min2 = i;
            }
            if (i > max2) {
                max2 = i;
            }
        }

        return (min1 > min2) && (max1 < max2);
    }
}

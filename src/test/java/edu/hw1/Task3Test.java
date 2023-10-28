package edu.hw1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw1.Task3.isNestable;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class Task3Test
{
    @Test
    @DisplayName("True")
    void trueOrdinaryTest1() {
        int[] array1 = {1, 2, 3, 4};
        int[] array2 = {0, 6};

        boolean result = isNestable(array1, array2);

        assertTrue(result);
    }

    @Test
    @DisplayName("True")
    void trueOrdinaryTest2() {
        int[] array1 = {3, 1};
        int[] array2 = {4, 0};

        boolean result = isNestable(array1, array2);

        assertTrue(result);
    }

    @Test
    @DisplayName("False")
    void falseOrdinaryTest3() {
        int[] array1 = {9, 9, 8};
        int[] array2 = {8, 9};

        boolean result = isNestable(array1, array2);

        assertFalse(result);
    }

    @Test
    @DisplayName("False")
    void falseOrdinaryTest4() {
        int[] array1 = {1, 2, 3, 4};
        int[] array2 = {2, 3};

        boolean result = isNestable(array1, array2);

        assertFalse(result);
    }

    @Test
    @DisplayName("Array1 of one element")
    void array1OneElementTest() {
        int[] array1 = {1};
        int[] array2 = {0, 2};

        boolean result = isNestable(array1, array2);

        assertTrue(result);
    }

    @Test
    @DisplayName("Array2 of one element")
    void array2OneElementTest() {
        int[] array1 = {0, 2};
        int[] array2 = {1};

        boolean result = isNestable(array1, array2);

        assertFalse(result);
    }

    @Test
    @DisplayName("Array1 of null element")
    void array1NullElementTest() {
        int[] array1 = {};
        int[] array2 = {1};

        boolean result = isNestable(array1, array2);

        assertFalse(result);
    }

    @Test
    @DisplayName("Array2 of null element")
    void array2NullElementTest() {
        int[] array1 = {1};
        int[] array2 = {};

        boolean result = isNestable(array1, array2);

        assertFalse(result);
    }

    @Test
    @DisplayName("Array1 is null")
    void array1NullTest ()
    {
        int[] array2 = {1};

        Assertions.assertThrows(IllegalArgumentException.class, () ->
            isNestable(null, array2), "IllegalArgumentException was expected");
    }

    @Test
    @DisplayName("Array2 is null")
    void array2NullTest ()
    {
        int[] array1 = {1};

        Assertions.assertThrows(IllegalArgumentException.class, () ->
            isNestable(array1, null), "IllegalArgumentException was expected");
    }


}

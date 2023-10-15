package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw1.Task5.isPalindromeDescendant;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class Task5Test
{
    @Test
    @DisplayName("True 11211230")
    void ordinaryTest1() {
        int number = 11211230;

        boolean result = isPalindromeDescendant(number);

        assertTrue(result);
    }

    @Test
    @DisplayName("True 13001120")
    void ordinaryTest2() {
        int number = 13001120;

        boolean result = isPalindromeDescendant(number);

        assertTrue(result);
    }

    @Test
    @DisplayName("True 23336014")
    void ordinaryTest3() {
        int number = 23336014;

        boolean result = isPalindromeDescendant(number);

        assertTrue(result);
    }

    @Test
    @DisplayName("True 11")
    void ordinaryTest4() {
        int number = 11;

        boolean result = isPalindromeDescendant(number);

        assertTrue(result);
    }

    @Test
    @DisplayName("One digit and 0")
    void oneDigitTest() {
        int number = 0;

        boolean result = isPalindromeDescendant(number);

        assertTrue(result);
    }

    @Test
    @DisplayName("Odd number of digits and number is a palindrome")
    void oddNumberDigitsTest1() {
        int number = 111;

        boolean result = isPalindromeDescendant(number);

        assertTrue(result);
    }

    @Test
    @DisplayName("Odd number of digits and number is not a palindrome")
    void oddNumberDigitsTest2() {
        int number = 123;

        boolean result = isPalindromeDescendant(number);

        assertFalse(result);
    }

    @Test
    @DisplayName("Sum of digits greater than 9")
    void greater9Test() {
        int number = 6565;

        boolean result = isPalindromeDescendant(number);

        assertTrue(result);
    }
}

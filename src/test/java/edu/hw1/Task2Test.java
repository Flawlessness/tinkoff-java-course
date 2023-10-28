package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw1.Task2.countDigits;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test
{
    @Test
    @DisplayName("0")
    void nullNumber() {
        int number = 0;

        int result = countDigits(number);

        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("1 digit")
    void oneDigit() {
        int number = 7;

        int result = countDigits(number);

        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("10 digits")
    void tenDigits() {
        int number = 2000000000;

        int result = countDigits(number);

        assertThat(result).isEqualTo(10);
    }

    @Test
    @DisplayName("Negative number")
    void negativeNumber() {
        int number = -2000000000;

        int result = countDigits(number);

        assertThat(result).isEqualTo(10);
    }
}

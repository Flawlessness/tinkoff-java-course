package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw1.Task7.rotateLeft;
import static edu.hw1.Task7.rotateRight;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task7Test
{
    @Test
    @DisplayName("rotateLeft(16, 1) 10000 -> 00001")
    void ordinaryLeftTest1() {
        int number = 16;
        int shift = 1;

        int result = rotateLeft(number, shift);

        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("rotateLeft(17, 2) 10001 -> 00110")
    void ordinaryLeftTest2() {
        int number = 17;
        int shift = 2;

        int result = rotateLeft(number, shift);

        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("rotateLeft(1, 3) 1 -> 1")
    void oneDigitLeftTest() {
        int number = 1;
        int shift = 3;

        int result = rotateLeft(number, shift);

        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("rotateLeft(0, 3) 0 -> 0")
    void nullLeftTest() {
        int number = 0;
        int shift = 3;

        int result = rotateLeft(number, shift);

        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("rotateLeft(MAX_VALUE, 3) MAX_VALUE -> MAX_VALUE")
    void maxLeftTest() {
        int number = Integer.MAX_VALUE;
        int shift = 3;

        int result = rotateLeft(number, shift);

        assertThat(result).isEqualTo(Integer.MAX_VALUE);
    }

    @Test
    @DisplayName("rotateRight(16, 1) 10000 -> 01000")
    void ordinaryRightTest1() {
        int number = 16;
        int shift = 1;

        int result = rotateRight(number, shift);

        assertThat(result).isEqualTo(8);
    }

    @Test
    @DisplayName("rotateRight(17, 2) 10001 -> 01100")
    void ordinaryRightTest2() {
        int number = 17;
        int shift = 2;

        int result = rotateRight(number, shift);

        assertThat(result).isEqualTo(12);
    }

    @Test
    @DisplayName("rotateRight(1, 3) 1 -> 1")
    void oneDigitRightTest() {
        int number = 1;
        int shift = 3;

        int result = rotateRight(number, shift);

        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("rotateRight(0, 3) 0 -> 0")
    void nullRightTest() {
        int number = 0;
        int shift = 3;

        int result = rotateRight(number, shift);

        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("rotateRight(MAX_VALUE, 3) MAX_VALUE -> MAX_VALUE")
    void maxRightTest() {
        int number = Integer.MAX_VALUE;
        int shift = 3;

        int result = rotateRight(number, shift);

        assertThat(result).isEqualTo(Integer.MAX_VALUE);
    }

}

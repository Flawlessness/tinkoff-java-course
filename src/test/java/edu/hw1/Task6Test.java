package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw1.Task6.countK;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task6Test
{
    @Test
    @DisplayName("3524 - 3")
    void ordinaryTest1() {
        int number = 3524;

        int result = countK(number);

        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("6621 - 5")
    void ordinaryTest2() {
        int number = 6621;

        int result = countK(number);

        assertThat(result).isEqualTo(5);
    }

    @Test
    @DisplayName("6554 - 4")
    void ordinaryTest3() {
        int number = 6554;

        int result = countK(number);

        assertThat(result).isEqualTo(4);
    }

    @Test
    @DisplayName("1234 - 3")
    void ordinaryTest4() {
        int number = 1234;

        int result = countK(number);

        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("2005 - 7")
    void ordinaryTest5() {
        int number = 2005;

        int result = countK(number);

        assertThat(result).isEqualTo(7);
    }

    @Test
    @DisplayName("Test with the addition of zero to an intermediate result")
    void nullTest() {
        int number = 1222;

        int result = countK(number);

        assertThat(result).isEqualTo(5);
    }

    @Test
    @DisplayName("Incorrect input - 1000")
    void incorrectInputTest1() {
        int number = 1000;

        int result = countK(number);

        assertThat(result).isEqualTo(-1);
    }

    @Test
    @DisplayName("Incorrect input - 1111")
    void incorrectInputTest2() {
        int number = 1111;

        int result = countK(number);

        assertThat(result).isEqualTo(-1);
    }

    @Test
    @DisplayName("Incorrect input - 10000")
    void incorrectInputTest3() {
        int number = 10000;

        int result = countK(number);

        assertThat(result).isEqualTo(-1);
    }
}

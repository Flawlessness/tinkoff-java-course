package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw3.Task4.convertToRoman;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task4Test {
    @Test
    @DisplayName("Ordinary test 1")
    void ordinaryTest1() {
        int inputNumber = 1;

        String result = convertToRoman(inputNumber);

        assertThat(result).isEqualTo("I");
    }

    @Test
    @DisplayName("Ordinary test 2")
    void ordinaryTest2() {
        int inputNumber = 2;

        String result = convertToRoman(inputNumber);

        assertThat(result).isEqualTo("II");
    }

    @Test
    @DisplayName("Ordinary test 3")
    void ordinaryTest3() {
        int inputNumber = 643;

        String result = convertToRoman(inputNumber);

        assertThat(result).isEqualTo("DCXLIII");
    }
}

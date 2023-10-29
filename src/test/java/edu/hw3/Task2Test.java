package edu.hw3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static edu.hw3.Task2.clusterize;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {
    @Test
    @DisplayName("Ordinary test 1")
    void ordinaryTest1() {
        String input = "()()()";
        List<String> expectedResult = List.of(new String[] {"()", "()", "()"});

        List<String> result = clusterize(input);

        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("Ordinary test 2")
    void ordinaryTest2() {
        String input = "((()))(())()()(()())";
        List<String> expectedResult = List.of(new String[] {"((()))", "(())", "()", "()", "(()())"});

        List<String> result = clusterize(input);

        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("IllegalArgumentException 1")
    void illegalArgumentExceptionTest1() {
        String input = "Hello";

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            clusterize(input);
        });
    }

    @Test
    @DisplayName("IllegalArgumentException 2")
    void illegalArgumentExceptionTest2() {
        String input = "(";

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            clusterize(input);
        });
    }

    @Test
    @DisplayName("IllegalArgumentException 3")
    void illegalArgumentExceptionTest3() {
        String input = ")";

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            clusterize(input);
        });
    }
}

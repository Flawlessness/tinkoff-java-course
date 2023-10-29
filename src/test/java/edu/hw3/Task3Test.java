package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Map;
import static edu.hw3.Task3.freqDict;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Test {
    @Test
    @DisplayName("String test")
    void stringTest() {
        List<String> inputList = List.of("hello", "hello", "know");
        var expectedResult = Map.ofEntries(
            Map.entry("hello", 2),
            Map.entry("know", 1)
        );

        Map<String, Integer> result = freqDict(inputList);

        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("Integer test")
    void integerTest() {
        List<Integer> inputList = List.of(1, 1, 3);
        var expectedResult = Map.ofEntries(
            Map.entry(1, 2),
            Map.entry(3, 1)
        );

        Map<Integer, Integer> result = freqDict(inputList);

        assertThat(result).isEqualTo(expectedResult);
    }
}

package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Map;
import java.util.TreeMap;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task7Test {

    @Test
    @DisplayName("Put null as key test")
    public void nullTest() {
        Map<String, String> treeMap = new TreeMap<>(new Task7<>());
        treeMap.put("abc", "cba");
        treeMap.put(null, "1");
        assertThat(treeMap.containsKey(null)).isTrue();
    }
}

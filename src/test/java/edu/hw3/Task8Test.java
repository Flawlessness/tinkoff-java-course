package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task8Test {
    @Test
    @DisplayName("Stack characters test")
    public void stackCharacterTest() {
        Stack<Character> stack = new Stack<>();
        stack.push('a');
        stack.push('b');
        stack.push('c');
        Iterator<Character> iterator = new Task8<>(stack);

        assertThat(iterator.next()).isEqualTo('c');
        assertThat(iterator.next()).isEqualTo('b');
        assertThat(iterator.next()).isEqualTo('a');
    }

    @Test
    @DisplayName("List integer test")
    public void listIntegerTest() {
        Iterator<Integer> iterator = new Task8<>(List.of(1, 2, 3));

        assertThat(iterator.next()).isEqualTo(3);
        assertThat(iterator.next()).isEqualTo(2);
        assertThat(iterator.next()).isEqualTo(1);
    }

    @Test
    @DisplayName("HasNext test")
    public void hasNextTest() {
        Iterator<Integer> iterator = new Task8<>(List.of(1));

        assertThat(iterator.hasNext()).isTrue();
        iterator.next();
        assertThat(iterator.hasNext()).isFalse();
    }
}

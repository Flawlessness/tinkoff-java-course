package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw3.Task1.atbash;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class Task1Test
{
    @Test
    @DisplayName("Checking register preservation")
    void registerPreservationTest() {
        String originalString = "Hello";

        String result = atbash(originalString);

        assertThat(result).isEqualTo("Svool");
    }

    @Test
    @DisplayName("Checking for ignoring a non-Latin alphabet character")
    void ignoringNonLatinCharacterTest() {
        String originalString = "Привет!";

        String result = atbash(originalString);

        assertThat(result).isEqualTo("Привет!");
    }

    @Test
    @DisplayName("Ordinary test")
    void ordinaryTest() {
        String originalString = "Any fool can write code that a computer can understand. Good programmers write code that humans can understand. ― Martin Fowler";

        String result = atbash(originalString);

        assertThat(result).isEqualTo("Zmb ullo xzm dirgv xlwv gszg z xlnkfgvi xzm fmwvihgzmw. Tllw kiltiznnvih dirgv xlwv gszg sfnzmh xzm fmwvihgzmw. ― Nzigrm Uldovi");
    }


}

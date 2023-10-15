package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw1.Task4.fixString;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task4Test
{
    @Test
    @DisplayName("123456 -> 214365")
    void ordinaryTest1() {
        String brokenString = "123456";

        String result = fixString(brokenString);

        assertThat(result).isEqualTo("214365");
    }

    @Test
    @DisplayName("hTsii  s aimex dpus rtni.g -> This is a mixed up string.")
    void ordinaryTest2() {
        String brokenString = "hTsii  s aimex dpus rtni.g";

        String result = fixString(brokenString);

        assertThat(result).isEqualTo("This is a mixed up string.");
    }

    @Test
    @DisplayName("Odd length string")
    void oddLengthStringTest() {
        String brokenString = "123";

        String result = fixString(brokenString);

        assertThat(result).isEqualTo("213");
    }

    @Test
    @DisplayName("One element string")
    void oneElementStringTest() {
        String brokenString = "1";

        String result = fixString(brokenString);

        assertThat(result).isEqualTo("1");
    }

    @Test
    @DisplayName("Empty string")
    void emptyStringTest() {
        String brokenString = "";

        String result = fixString(brokenString);

        assertThat(result).isEqualTo("");
    }
}

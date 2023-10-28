package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static edu.hw1.Task1.minutesToSeconds;

public class Task1Test
{
    @Test
    @DisplayName("0 seconds")
    void minValueTest() {
        String time = "00:00";

        int result = minutesToSeconds(time);

        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("Format without not significant zero")
    void notSignificantZeroTest() {
        String time = "1:1";

        int result = minutesToSeconds(time);

        assertThat(result).isEqualTo(61);
    }

    @Test
    @DisplayName("Integer.MAX_VALUE = seconds")
    void maxValueTest() {
        String time = "35791394:07";

        int result = minutesToSeconds(time);

        assertThat(result).isEqualTo(Integer.MAX_VALUE);
    }

    @Test
    @DisplayName("Integer.MAX_VALUE > seconds")
    void maxValueErrorTest() {
        String time = "35791394:08";

        int result = minutesToSeconds(time);

        assertThat(result).isEqualTo(-1);
    }

    @Test
    @DisplayName("Seconds < 0")
    void negativeSeconds() {
        String time = "12:-1";

        int result = minutesToSeconds(time);

        assertThat(result).isEqualTo(-1);
    }

    @Test
    @DisplayName("Seconds >= 60")
    void limitSeconds() {
        String time = "12:61";

        int result = minutesToSeconds(time);

        assertThat(result).isEqualTo(-1);
    }

    @Test
    @DisplayName("Minutes < 0")
    void negativeMinutes() {
        String time = "-1:12";

        int result = minutesToSeconds(time);

        assertThat(result).isEqualTo(-1);
    }

    @Test
    @DisplayName("100 seconds")
    void simpleTest() {
        String time = "01:40";

        int result = minutesToSeconds(time);

        assertThat(result).isEqualTo(100);
    }
    @Test
    @DisplayName("incorrect input: letters")
    void lettersTest() {
        String time = "a:40";

        int result = minutesToSeconds(time);

        assertThat(result).isEqualTo(-1);
    }

}

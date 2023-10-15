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

        assertThat(minutesToSeconds(time)).isEqualTo(0);
    }

    @Test
    @DisplayName("Integer.MAX_VALUE = seconds")
    void maxValueTest() {
        String time = "35791394:07";

        assertThat(minutesToSeconds(time)).isEqualTo(Integer.MAX_VALUE);
    }

    @Test
    @DisplayName("Integer.MAX_VALUE > seconds")
    void maxValueErrorTest() {
        String time = "35791394:08";

        assertThat(minutesToSeconds(time)).isEqualTo(-1);
    }

    @Test
    @DisplayName("Seconds < 0")
    void negativeSeconds() {
        String time = "12:-1";

        assertThat(minutesToSeconds(time)).isEqualTo(-1);
    }

    @Test
    @DisplayName("Seconds >= 60")
    void limitSeconds() {
        String time = "12:61";

        assertThat(minutesToSeconds(time)).isEqualTo(-1);
    }

    @Test
    @DisplayName("Minutes < 0")
    void negativeMinutes() {
        String time = "-1:12";

        assertThat(minutesToSeconds(time)).isEqualTo(-1);
    }

    @Test
    @DisplayName("100 seconds")
    void simpleTest() {
        String time = "01:40";

        assertThat(minutesToSeconds(time)).isEqualTo(100);
    }
}

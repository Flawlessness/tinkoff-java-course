package edu.hw2;

import edu.hw2.task4.StackInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw2.task4.StackInfo.callingInfo;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class Task4Test {
    @Test
    @DisplayName("Тест функции callingInfo")
    public void callingInfoTest() {
        var result = callingInfo();

        assertThat(result).isEqualTo(new StackInfo.CallingInfo(
            "edu.hw2.Task4Test",
            "callingInfoTest"
        ));
    }
}

package edu.hw2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import edu.hw2.task1.Expr.*;

public class Task1Test {
    @Test
    @DisplayName("Тест инцизилации числа")
    void constantTest() {
        var result = new Constant(new Constant(-1));

        assertThat(result.evaluate()).isEqualTo(-1);
    }

    @Test
    @DisplayName("Тест отрицания")
    void negateTest() {
        var negateFive = new Constant(new Constant(-5));

        var result = new Negate(new Constant(negateFive));

        assertThat(result.evaluate()).isEqualTo(5);
    }

    @Test
    @DisplayName("Тест сложения чисел")
    void additionTest() {
        var negateTwo = new Constant(new Constant(-2));
        var four = new Constant(new Constant(4));
        double seven = 7;

        var result = new Addition(negateTwo, four);
        result = new Addition(result, seven);
        result = new Addition(seven, result);

        assertThat(result.evaluate()).isEqualTo(16);
    }

    @Test
    @DisplayName("Тест возведения в степень")
    void exponentTest() {
        var negateOne = new Constant(new Constant(-1));
        var three = new Constant(new Constant(3));
        double two = 2;

        var result = new Exponent(three, two);
        result = new Exponent(two, result);
        result = new Exponent(result, negateOne);

        assertThat(result.evaluate()).isEqualTo((double) 1 / 512);
    }

    @Test
    @DisplayName("Тест умножения")
    void multiplicationTest() {
        var negateFive = new Constant(new Constant(-5));
        var six = new Constant(new Constant(6));
        double two = 2;

        var result = new Multiplication(negateFive, six);
        result = new Multiplication(two, result);
        result = new Multiplication(result, two);

        assertThat(result.evaluate()).isEqualTo(-120);
    }

    @Test
    @DisplayName("Общий тест")
    void generalTest() {
        var two = new Constant(2);
        var four = new Constant(4);

        var negOne = new Negate(new Constant(1));
        var sumTwoFour = new Addition(two, four);
        var mult = new Multiplication(sumTwoFour, negOne);
        var exp = new Exponent(mult, 2);
        var result = new Addition(exp, new Constant(1));

        assertThat(result.evaluate()).isEqualTo(37);
    }

}

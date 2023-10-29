package edu.hw3;

import edu.hw3.task6.Stock;
import edu.hw3.task6.MyStock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task6Test {
    private MyStock myStock;
    private final Stock stockForRemove = new Stock("Gazprom", 100.5);

    @BeforeEach
    public void makeStockMarket() {
        myStock = new MyStock();
        myStock.add(new Stock("Aeroflot", 50.7));
        myStock.add(new Stock("X5 Group", 1245.3));
    }

    @Test
    @DisplayName("add method test")
    public void addStockToMarket() {
        Stock stock = new Stock("Tinkoff", 10000);

        myStock.add(stock);

        assertTrue(myStock.getStockQueue().contains(stock));
    }

    @Test
    @DisplayName("remove method test")
    public void removeStockFromMarket() {
        myStock.remove(stockForRemove);

        assertFalse(myStock.getStockQueue().contains(stockForRemove));
    }

    @Test
    @DisplayName("mostValuableStock method test")
    public void returnFirstStockFromMarket() {
        Stock stock = new Stock("Tinkoff", 10000);

        myStock.add(stock);

        assertThat(myStock.mostValuableStock()).isEqualTo(stock);
    }

    @Test
    @DisplayName("IllegalArgumentException Add")
    void addIllegalArgumentExceptionTest() {
        Stock stock = null;

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            myStock.add(stock);
        });
    }

    @Test
    @DisplayName("IllegalArgumentException Remove")
    void removeIllegalArgumentExceptionTest() {
        Stock stock = null;

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            myStock.remove(stock);
        });
    }

}

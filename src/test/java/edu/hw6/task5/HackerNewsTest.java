package edu.hw6.task5;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
public class HackerNewsTest {

    @Test
    void testHackerNews() {

        HackerNews hackerNews = new HackerNews();

        long[] IDs = hackerNews.hackerNewsTopStories();

        assertTrue(
            IDs.length > 0
        );

        assertDoesNotThrow(() -> {
            String topic = hackerNews.news(IDs[0]);
        });

    }
}

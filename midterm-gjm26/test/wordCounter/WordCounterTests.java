package wordCounter;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class WordCounterTests {

    public abstract WordCounter createWordCounter();
    @Test
    @DisplayName("Test add and getCount")
    void testAddAndGetCount() {
        WordCounter wc = createWordCounter();
        wc.add("apple");
        wc.add("banana");
        wc.add("apple");
        assertEquals(2, wc.getCount("apple"));
        assertEquals(1, wc.getCount("banana"));
    }

    @Test
    @DisplayName("Test unique")
    void testUniqueWords() {
        WordCounter wc = createWordCounter();
        wc.add("apple");
        wc.add("banana");
        wc.add("apple");
        List<String> expected = Arrays.asList("apple", "banana");
        assertEquals(expected, wc.unique());
    }

}

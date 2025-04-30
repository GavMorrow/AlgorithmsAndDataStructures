package minMaxPQ;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class MinMaxPQTests {

    public abstract MinMaxPQ createMinMaxPQ();
    @Test
    @DisplayName("Test add, removeMin, removeMax")
    void testAddAndRemove() {
        MinMaxPQ data = createMinMaxPQ();
        data.add(5);
        data.add(3);
        data.add(10);
        assertEquals(3, data.removeMin());
        assertEquals(10, data.removeMax());

        data.add(1);
        assertEquals(1, data.removeMin());
        assertEquals(5, data.removeMax());
    }
}

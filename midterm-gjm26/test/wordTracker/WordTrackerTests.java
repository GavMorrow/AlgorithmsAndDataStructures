package wordTracker;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class WordTrackerTests {

    public abstract WordTracker createWordTracker();
    @Test
    @DisplayName("Test 1 match")
    void testOneMatch() {
        WordTracker wt = createWordTracker();
        wt.addObserved("Test");
        wt.addKnown("Test");
        assertEquals(1, wt.countObservedInKnown());
    }

    @Test
    @DisplayName("Test 1 match with 1 extra observed")
    void testOneMatchWithOneExtraObserved() {
        WordTracker wt = createWordTracker();
        wt.addObserved("Hello");
        wt.addObserved("World");
        wt.addKnown("Hello");
        assertEquals(1, wt.countObservedInKnown());
    }

}

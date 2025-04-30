package placesDatabase;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class PlacesDatabaseTests {

    public abstract PlacesDatabase createPlacesDatabase();
    @Test
    @DisplayName("Test closestToX")
    void testClosestToX() {
        PlacesDatabase db = createPlacesDatabase();
        db.add(new Place(2, 3));
        db.add(new Place(6, 7));
        db.add(new Place(-5, 9));

        Place closest = db.closestToX(3);
        assertEquals(2, closest.x);
        assertEquals(3, closest.y);
    }

    @Test
    @DisplayName("Test closestToY")
    void testClosestToY() {
        PlacesDatabase db = createPlacesDatabase();
        db.add(new Place(2, 3));
        db.add(new Place(6, 7));
        db.add(new Place(-5, 9));

        Place closest = db.closestToY(8);
        assertEquals(6, closest.x);
        assertEquals(7, closest.y);
    }
}

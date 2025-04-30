package placesDatabase;

public interface PlacesDatabase {

    void add(Place place);

    Place closestToX(int x);

    Place closestToY(int y);

}


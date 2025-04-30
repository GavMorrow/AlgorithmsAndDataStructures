package wordTracker;

public interface WordTracker {

    void addObserved(String word);

    void addKnown(String word);

    int countObservedInKnown();

}

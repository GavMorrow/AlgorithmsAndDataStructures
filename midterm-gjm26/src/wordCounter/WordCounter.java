package wordCounter;

import java.util.List;

public interface WordCounter {

    void add(String word);

    List<String> unique();

    int getCount(String word);

}

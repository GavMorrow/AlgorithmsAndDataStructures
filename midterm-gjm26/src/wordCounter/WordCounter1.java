package wordCounter;

import java.util.*;

public class WordCounter1 implements WordCounter {
    private final TreeMap<String, Integer> map;

    public WordCounter1() {
        map = new TreeMap<>();
    }

    public void add(String word) {
        if (map.containsKey(word)) {
            int num = map.get(word);
            map.put(word, num + 1);
        } else {
            map.put(word, 1);
        }
    }

    public List<String> unique() {
        return new ArrayList<>(map.keySet());
    }

    public int getCount(String word) {
        return map.get(word);
    }
}


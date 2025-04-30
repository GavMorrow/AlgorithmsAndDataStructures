package minMaxPQ;
import java.util.ArrayList;
import java.util.Collections;
import java.util.NoSuchElementException;

public class MinMaxPQ2 implements MinMaxPQ {

    private final ArrayList<Integer> list;
    private int front;
    public MinMaxPQ2() {
        list = new ArrayList<>();
    }

    public void add(int num) {
        list.add(num);
        Collections.sort(list);
        front = 0;
    }

    public int removeMin() {
        if (list.isEmpty()) {
            throw new NoSuchElementException("Empty");
        }
        int num = list.get(front);
        list.remove(front);
        front++;
        return num;
    }

    public int removeMax() {
        if (list.isEmpty()) {
            throw new NoSuchElementException("Empty");
        }
        int num = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        return num;
    }
}


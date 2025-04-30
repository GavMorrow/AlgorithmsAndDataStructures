package minMaxPQ;

import java.util.NoSuchElementException;
import java.util.PriorityQueue;

public class MinMaxPQ1 implements MinMaxPQ {

    private final minHeap heap;
    private static class minHeap {
        private final PriorityQueue<Integer> pq;

        private minHeap() {
            this.pq = new PriorityQueue<>();
        }
        private void add(int num) {
            pq.add(num);

        }

        private int peekMax() {
            if (pq.isEmpty()) {
                throw new NullPointerException("Danger Danger");
            }
            int max = Integer.MIN_VALUE;
            for (int elem : pq) {
                if (elem > max) {
                    max = elem;
                }
            }
            return max;
        }

        private int getMin() {
            if (pq.isEmpty()) {
                throw new NoSuchElementException("You're banned");
            }
            return pq.peek();
        }

        private int removeMax() {
            int num = this.peekMax();
            pq.remove(num);
            return num;
        }

        private int removeMin() {
            int num = this.getMin();
            pq.remove(num);
            return num;
        }
    }

    public MinMaxPQ1() {
        heap = new minHeap();
    }

    public void add(int num) {
        heap.add(num);
    }

    public int removeMin() {
        return heap.removeMin();
    }

    public int removeMax() {
        return heap.removeMax();
    }
}


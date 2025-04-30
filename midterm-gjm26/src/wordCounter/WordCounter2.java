package wordCounter;

import java.util.*;


public class WordCounter2 implements WordCounter {

    private final TernarySearchTreeAutocomplete tst;
    private final Set<String> words;
    public static class TernarySearchTreeAutocomplete {
        /**
         * The overall root of the tree: the first character of the first autocompletion term added to this tree.
         */
        private Node overallRoot;

        /**
         * Constructs an empty instance.
         */
        public TernarySearchTreeAutocomplete() {
            overallRoot = null;
        }


        private void add(String word) {
            overallRoot = add(overallRoot, word, 0);
        }

        private Node add(Node node, CharSequence term, int index) {
            if (node == null) {
                node = new Node(term.charAt(index));
            }

            char currentChar = term.charAt(index);
            if (currentChar < node.data) {
                node.left = add(node.left, term, index);
            } else if (currentChar > node.data) {
                node.right = add(node.right, term, index);
            } else {
                if (index < term.length() - 1) {
                    node.mid = add(node.mid, term, index + 1);
                } else {
                    node.count++;
                }
            }
            return node;
        }

        private Node getWord(CharSequence word) {
            Node node = overallRoot;
            int i = 0;
            while (i < word.length()) {
                if (node == null) {
                    return null;
                }
                if (word.charAt(i) < node.data) {
                    node = node.left;
                } else if (word.charAt(i) > node.data) {
                    node = node.right;
                } else {
                    i++;
                    if (i < word.length()) {
                        node = node.mid;
                    }
                }
            }
            return node;
        }

        /**
         * A search tree node representing a single character in an autocompletion term.
         */
        public static class Node {
            private final char data;
            private Node left;
            private Node mid;
            private Node right;
            private int count;

            public Node(char data) {
                this.data = data;
                this.left = null;
                this.mid = null;
                this.right = null;
                this.count = 0;
            }
        }
    }

    public WordCounter2() {
        tst = new TernarySearchTreeAutocomplete();
        words = new TreeSet<>();
    }

    public void add(String word) {
        tst.add(word);
        words.add(word);
    }

    public List<String> unique() {
        return new ArrayList<>(words);
    }

    public int getCount(String word) {
        return Objects.requireNonNull(tst.getWord(word)).count;
    }
}


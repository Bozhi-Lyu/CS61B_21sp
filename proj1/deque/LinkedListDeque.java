package deque;

import java.util.Iterator;

public class LinkedListDeque<DequeT> implements Deque<DequeT>, Iterable<DequeT> {

    private static class DLList<T> {
        T item;
        DLList<T> prev;
        DLList<T> next;
        DLList(T i, DLList<T> p, DLList<T> n) {
            item = i;
            prev = p;
            next = n;
        }
    }

    private int size;
    private DLList<DequeT> sentinel = new DLList<>(null, null, null);

    public LinkedListDeque() {
        size = 0;
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }

    @Override
    public void addFirst(DequeT x) {
        DLList<DequeT> newItem = new DLList<>(x, sentinel, sentinel.next);
        sentinel.next.prev = newItem;
        sentinel.next = newItem;
        size += 1;
    }

    @Override
    public void addLast(DequeT x) {
        DLList<DequeT> newItem = new DLList<>(x, sentinel.prev, sentinel);
        sentinel.prev.next = newItem;
        sentinel.prev = newItem;
        size += 1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        DLList<DequeT> p = sentinel.next;
        for (int i = 0; i < size; i++) {
            System.out.print(p.item + " ");
            p = p.next;
        }
        System.out.println();
    }

    @Override
    public DequeT removeFirst() {
        if (sentinel.next == sentinel) {
            return null;
        } else {
            DLList<DequeT> removedItem = sentinel.next;
            DLList<DequeT> newHead = sentinel.next.next;
            sentinel.next = newHead;
            newHead.prev = sentinel;
            size -= 1;
            return removedItem.item;
        }
    }

    @Override
    public DequeT removeLast() {
        if (sentinel.prev == sentinel) {
            return null;
        } else {
            DLList<DequeT> removedItem = sentinel.prev;
            DLList<DequeT> newEnd = sentinel.prev.prev;
            sentinel.prev = newEnd;
            newEnd.next = sentinel;
            size -= 1;
            return removedItem.item;
        }
    }

    @Override
    public DequeT get(int index) {
        DLList<DequeT> p = sentinel.next;
        for (int i = 0; i < index; i++) {
            if (p == sentinel) {
                return null;
            }
            p = p.next;
        }
        return p.item;
    }

    /** Helps to recursively get the ith item. */
    private DequeT recursionHelper(DLList<DequeT> p, int i) {
        if (p == sentinel) {
            return null;
        } else if (i == 0) {
            return p.item;
        } else {
            return recursionHelper(p.next, i - 1);
        }
    }

    /** Same as get but uses recursion. */
    public DequeT getRecursive(int index) {
        return recursionHelper(sentinel.next, index);
    }

    public Iterator<DequeT> iterator() {
        return new LLDIterator();
    }

    private class LLDIterator implements Iterator<DequeT> {
        private DLList<DequeT> currentNode;

        public LLDIterator() {
            currentNode = sentinel.next;
        }

        @Override
        public boolean hasNext() {
            return currentNode != sentinel;
        }

        @Override
        public DequeT next() {
            DequeT item = currentNode.item;
            currentNode = currentNode.next;
            return item;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Deque)) {
            return false;
        }

        if (!(((Deque<?>) o).size() == this.size())) {
            return false;
        }

        for (int i = 0; i < size(); i++) {
            if (!(((Deque<?>) o).get(i).equals(this.get(i)))) {
                return false;
            }
        }

        return true;
    }
}












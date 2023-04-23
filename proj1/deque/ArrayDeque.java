package deque;

import java.util.Iterator;

public class ArrayDeque<T> implements Deque<T>, Iterable<T> {

    private int size;
    private int head;
    private int end;
    private int length = 8;

    private class AList<T> {
        private T[] items;
        private AList() {
            items = (T []) new Object[length];
        }
    }

    private AList<T> AL = new AList<>();

    public ArrayDeque() {
        size = 0;
        head = 0;
        end = 0;
    }

    @Override
    public void addFirst(T x) {
        if (size == 0) {
            AL.items[head] = x;
            size += 1;
            return;
        }

        resize(1);
        head = (head - 1 + length) % length;
        AL.items[head] = x;
        size += 1;
    }

    @Override
    public void addLast(T x) {
        if (size == 0) {
            AL.items[end] = x;
            size += 1;
            return;
        }

        resize(1);
        end = (end + 1) % length;
        AL.items[end] = x;
        size += 1;
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        int p = head;
        for (int i = 0; i < size; i++) {
            System.out.print(AL.items[p] + " ");
            p = (p + 1) % length;
        }
        System.out.println();
    }

    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        if (size == 1) {
            T removedItem = AL.items[head];
            AL.items[head] = null;
            size -= 1;
            return removedItem;
        }

        resize(-1);
        T removedItem = AL.items[head];
        AL.items[head] = null;
        head = (head + 1) % length;
        size -= 1;
        return removedItem;
    }

    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        if (size == 1) {
            T removedItem = AL.items[end];
            AL.items[end] = null;
            size -= 1;
            return removedItem;
        }

        resize(-1);
        T removedItem = AL.items[end];
        AL.items[end] = null;
        end = (end - 1 + length) % length;
        size -= 1;
        return removedItem;
    }

    private void resize(int i) {

        int oriLength = length;
        if (i == 1) { //When adding an item:
            if (length == size) {
                length *= 2;
            } else {
                return;
            }
        } else if (i == -1) { //when removing an item:
            if (length >= 16 && length > 4 * (size - 1)) {
                length /= 2;
            } else {
                return;
            }
        }

        AList<T> resizedAL = new AList<>();
        for (int j = 0; j < size; j++) {
            resizedAL.items[j] = AL.items[(head + j) % oriLength];
            //After resizing the ALList, head should be equal to 0
        }
        AL = resizedAL;
        head = 0;
        end = head + size - 1;
    }

    @Override
    public T get(int index) {
        if (index > size) {
            return null;
        }
        return AL.items[(head + index) % length];
    }

    public Iterator<T> iterator() {
        return new ADIterator();
    }

    private class ADIterator implements Iterator<T> {

        private int currentItem;
        ADIterator() {
            currentItem = 0;
        }

        @Override
        public boolean hasNext() {
            return currentItem < size;
        }

        @Override
        public T next() {
            T item = AL.items[currentItem];
            currentItem += 1;
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










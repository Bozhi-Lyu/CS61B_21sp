package deque;

public class ArrayDeque<DequeT> {

    private int size;
    private int head;
    private int end;
    private int length = 8;

    private class AList<T> {
        private T[] items;
        private AList(){
            items = (T []) new Object[length];
        }
    }

    private AList<DequeT> AL = new AList<>();

    public ArrayDeque(){
        size = 0;
        head = 0;
        end = 0;
    }

    public void addFirst(DequeT x){
        if (size == 0){
            AL.items[head] = x;
            size += 1;
            return;
        }

        resize(1);
        head = (head - 1 + length) % length;
        AL.items[head] = x;
        size += 1;
    }

    public void addLast(DequeT x){
        if (size == 0){
            AL.items[end] = x;
            size += 1;
            return;
        }

        resize(1);
        end = (end + 1) % length;
        AL.items[end] = x;
        size += 1;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        int p = head;
        for (int i = 0; i < size; i++){
            System.out.print(AL.items[p] + " ");
            p = (p + 1) % length;
        }
        System.out.println();
    }

    public DequeT removeFirst(){
        if (size == 0){
            return null;
        }
        if (size == 1){
            DequeT removedItem = AL.items[head];
            AL.items[head] = null;
            size -= 1;
            return removedItem;
        }

        resize(-1);
        DequeT removedItem = AL.items[head];
        AL.items[head] = null;
        head = (head + 1) % length;
        size -= 1;
        return removedItem;
    }

    public DequeT removeLast(){
        if (size == 0){
            return null;
        }
        if (size == 1){
            DequeT removedItem = AL.items[end];
            AL.items[end] = null;
            size -= 1;
            return removedItem;
        }

        resize(-1);
        DequeT removedItem = AL.items[end];
        AL.items[end] = null;
        end = (end - 1 + length) % length;
        size -= 1;
        return removedItem;
    }

    private void resize(int i){

        int oriLength = length;
        if (i == 1){ //When adding an item:
            if (length == size){
                length *= 2;
            } else {
                return;
            }
        } else if (i == -1) { //when removing an item:
            if (length >= 16 && length > 4 * (size - 1)){
                length /= 2;
            } else {
                return;
            }
        }

        AList<DequeT> resizedAL = new AList<>();
        for (int j = 0; j < size; j++){
            resizedAL.items[j] = AL.items[(head + j) % oriLength];
            //After resizing the ALList, head should be equal to 0
        }
        AL = resizedAL;
        head = 0;
        end = head + size - 1;
    }

    public DequeT get(int index){
        if (index > size){
            return null;
        }
        return AL.items[(head + index) % length];
    }

}









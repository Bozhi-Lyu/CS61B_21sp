package deque;
import java.util.Comparator;
import java.util.Deque;


public class MaxArrayDeque<T> extends ArrayDeque<T> {

    private final Comparator<T> defaultComparator;

    public MaxArrayDeque(Comparator<T> c){
        defaultComparator = c;
        new ArrayDeque<>();
    }

    public T max() {
        if (this.size() == 0) {
            return null;
        }

        T maxItem = this.get(0);
        for (int i = 1; i < this.size(); i++) {
            if (defaultComparator.compare(this.get(i), maxItem) > 0) {
                maxItem = this.get(i);
            }
        }
        return maxItem;
    }

    public T max(Comparator<T> c) {
        if (this.size() == 0) {
            return null;
        }

        T maxItem = this.get(0);
        for (int i = 1; i < this.size(); i++) {
            if (c.compare(this.get(i), maxItem) > 0) {
                maxItem = this.get(i);
            }
        }
        return maxItem;
    }
}

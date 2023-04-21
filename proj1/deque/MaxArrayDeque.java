package deque;
import java.util.Comparator;
import java.util.Deque;


public class MaxArrayDeque<Deque> extends ArrayDeque<Deque>{

    private Comparator<Deque> defaultComparator;

    public MaxArrayDeque(Comparator<Deque> c){
        defaultComparator = c;
        new ArrayDeque<>();
    }

    public Deque max(){
        if (this.size() == 0){
            return null;
        }

        Deque maxItem = this.get(0);
        for (int i = 1; i < this.size(); i++){
            if (defaultComparator.compare(this.get(i), maxItem) > 0){
                maxItem = this.get(i);
            }
        }
        return maxItem;
    }

    public Deque max(Comparator<Deque> c){
        if (this.size() == 0){
            return null;
        }

        Deque maxItem = this.get(0);
        for (int i = 1; i < this.size(); i++){
            if (c.compare(this.get(i), maxItem) > 0){
                maxItem = this.get(i);
            }
        }
        return maxItem;
    }
}

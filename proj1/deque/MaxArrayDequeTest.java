package deque;

import edu.princeton.cs.introcs.StdRandom;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;

import static org.junit.Assert.*;

public class MaxArrayDequeTest {

    public static class AlphabeticalComparator implements Comparator<String>{
        @Override
        public int compare(String s1, String s2){
            return s1.compareTo(s2);
        }
    }
    
    public static class LengthComparator implements Comparator<String>{
        @Override
        public int compare(String a, String b){
            Integer lengthA = a.length();
            Integer lengthB = b.length();
            return lengthA.compareTo(lengthB);
        }
    }

    public ArrayList<String> al = new ArrayList<>();

    /** Adds some random items(Strings) to the list.
     *  ensures the max item is returned in the default Comparator.*/
    @Test
    public void randomItemsTest(){
        Comparator<String> ac = new AlphabeticalComparator();
        MaxArrayDeque<String> mad = new MaxArrayDeque<>(ac);
        mad.addLast("cat");
        mad.addLast("doge");
        mad.addLast("elephant");
        mad.addLast("goose");
        mad.addLast("hi, I'm human.");

        String maxItem = mad.max();
        assertEquals("hi, I'm human.", maxItem);

    }

    /** Adds some random items(integers) to the list.
     *  ensures the max item is returned in the given Comparator.*/
    @Test
    public void givenComparatorTest(){
        Comparator<String> ac = new AlphabeticalComparator();
        MaxArrayDeque<String> mad = new MaxArrayDeque<>(ac);
        Comparator<String> lc = new LengthComparator();

        mad.addLast("cat");
        mad.addLast("doge");
        mad.addLast("elephant");
        mad.addLast("goose");
        mad.addLast("hi, I'm human.");

        String maxItem = mad.max(lc);
        assertEquals("hi, I'm human.", maxItem);

    }

    /** Ensures the return value is null when the array is null.*/
    @Test
    public void returnNullTest(){
        Comparator<String> ac = new AlphabeticalComparator();
        MaxArrayDeque<String> mad = new MaxArrayDeque<>(ac);

        String maxItem = mad.max();
        assertNull(maxItem);

    }


}

package deque;


import org.junit.Test;
import static org.junit.Assert.*;
import edu.princeton.cs.introcs.StdRandom;




/** Performs some basic linked list tests. */
public class RandomTest {

    /** randomly test ArrayDeque and LinkedListDeque */
    @Test
    public void randomizedTest() {

        ArrayDeque<Integer> ad = new ArrayDeque<>();
        LinkedListDeque<Integer> lld = new LinkedListDeque<>();
        int N = 10000;
        for (int i = 0; i < N; i++) {
            int operationNum = StdRandom.uniform(0, 7);
            if (operationNum == 0) {
                //addFirst
                int m = StdRandom.uniform(0, 100);
                ad.addFirst(m);
                lld.addFirst(m);

            } else if (operationNum == 1) {
                //addLast
                int m = StdRandom.uniform(0, 100);
                ad.addLast(m);
                lld.addLast(m);

            } else if (operationNum == 2) {
                //size
                assertEquals((int) ad.size(), (int) lld.size());

            } else if (operationNum == 3) {
                //removeFirst
                if (ad.size() == 0 || lld.size() == 0) {
                    continue;
                }
                Integer adR = ad.removeFirst();
                Integer lldR = lld.removeFirst();
                if (adR != null && lldR != null) {
                    assertEquals(adR, lldR);
                } else {
                    int adSize = ad.size();
                    int lldSize = lld.size();
                    assertEquals(adSize, lldSize);
                }
                assertTrue(ad.equals(lld));
                assertTrue(lld.equals(ad));


            } else if (operationNum == 4) {
                //removeLast
                if (ad.size() == 0 || lld.size() == 0) {
                    continue;
                }
                int adR = ad.removeLast();
                int lldR = lld.removeLast();
                assertEquals(adR, lldR);
                assertTrue(ad.equals(lld));
                assertTrue(lld.equals(ad));

            } else if (operationNum == 5) {
                //get
                int index1 = StdRandom.uniform(0, N);
                if (ad.get(index1) == null) {
                    assertNull(lld.get(index1));
                } else {
                    assertEquals((int) ad.get(index1), (int) lld.get(index1));
                }
                if (ad.size() != 0) {
                    int index2 = StdRandom.uniform(0, ad.size());
                    assertEquals((int) ad.get(index2), (int) lld.get(index2));
                }

            } else if (operationNum == 6) {
                //getRecursive in lld
                int index1 = StdRandom.uniform(0, N);
                if (ad.get(index1) == null) {
                    assertNull(lld.getRecursive(index1));
                } else {
                    assertEquals((int) ad.get(index1), (int) lld.getRecursive(index1));
                }
                if (ad.size() != 0) {
                    int index2 = StdRandom.uniform(0, ad.size());
                    assertEquals((int) ad.get(index2), (int) lld.getRecursive(index2));
                }

            }

        }


    }








}

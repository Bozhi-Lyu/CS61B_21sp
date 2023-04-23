package tester;

import static org.junit.Assert.*;

import edu.princeton.cs.introcs.StdRandom;
import org.junit.Test;
import student.StudentArrayDeque;

public class TestArrayDequeEC {

    /** Randomly tests the StudentArrayDeque method. */
    @Test
    public void RandomTest() {
        StudentArrayDeque<Integer> sad = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> ads = new ArrayDequeSolution<>();

        for (int i = 0; i < 1000; i++) {
            int opNum = StdRandom.uniform(0, 4);
            if (opNum == 0) {
                int Num = StdRandom.uniform(0, 100);
                sad.addFirst(Num);
                ads.addFirst(Num);
                System.out.println("addFirst(" + Num + ")");
            } else if (opNum == 1) {
                int Num = StdRandom.uniform(0, 100);
                sad.addLast(Num);
                ads.addLast(Num);
                System.out.println("addLast(" + Num + ")");
            } else if (opNum == 2) {
                if ((sad.size() == 0) || (ads.size() == 0)) {
                    continue;
                }

                Integer Rsad = sad.removeFirst();
                Integer Rads = ads.removeFirst();
                assertEquals("removeFirst()\n", Rsad, Rads);
                System.out.println("removeFirst()");

            } else if (opNum == 3) {
                if ((sad.size() == 0) || (ads.size() == 0)) {
                    continue;
                }

                Integer Rsad = sad.removeLast();
                Integer Rads = ads.removeLast();
                assertEquals("removeLast()\n", Rsad, Rads);
                System.out.println("removeLast()");

            }

            assertEquals("size()", sad.size(), ads.size());

        }
    }
}

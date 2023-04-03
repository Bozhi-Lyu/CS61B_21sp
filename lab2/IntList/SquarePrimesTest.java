package IntList;

import static org.junit.Assert.*;
import org.junit.Test;

public class SquarePrimesTest {

    /**
     * Here is a test for isPrime method. Try running it.
     * It passes, but the starter code implementation of isPrime
     * is broken. Write your own JUnit Test to try to uncover the bug!
     */
    @Test
    public void testSquarePrimesSimple() {
        IntList lst = IntList.of(14, 15, 16, 17, 18);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("14 -> 15 -> 16 -> 289 -> 18", lst.toString());
        assertTrue(changed);
    }

    @Test
    public void testSquarePrimes1() {
        IntList lst = IntList.of(2, 15, 3, 11, 71);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("4 -> 15 -> 9 -> 121 -> 5041", lst.toString());
        assertTrue(changed);
    }

    @Test
    public void testSquarePrimes2() {
        IntList lst = IntList.of(4, 100, 21, 8, 26);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("4 -> 100 -> 21 -> 8 -> 26", lst.toString());
        assertFalse(changed);
    }

    @Test
    public void testSquarePrimes3() {
        IntList lst = IntList.of(19, 97, 87, 23, 73);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("361 -> 9409 -> 87 -> 529 -> 5329", lst.toString());
        assertTrue(changed);
    }
}

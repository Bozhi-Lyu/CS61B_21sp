package deque;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;


/** Performs some basic linked list tests. */
public class ArrayDequeTest {

    @Test
    /** Adds a few things to the list, checking isEmpty() and size() are correct,
     * finally printing the results.*/
    public void addIsEmptySizeTest() {

        ArrayDeque<String> ad1 = new ArrayDeque<>();

		assertTrue("A newly initialized ArrayDeque should be empty", ad1.isEmpty());
		ad1.addFirst("front");

        assertEquals(1, ad1.size());
        assertFalse("lld1 should now contain 1 item", ad1.isEmpty());

		ad1.addLast("middle");
		assertEquals(2, ad1.size());

		ad1.addLast("back");
		assertEquals(3, ad1.size());

		System.out.println("Printing out deque: ");
		ad1.printDeque();

    }

    @Test
    /** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
    public void addRemoveTest() {

        ArrayDeque<Integer> ad1 = new ArrayDeque<>();
		// should be empty
		assertTrue("lld1 should be empty upon initialization", ad1.isEmpty());

		ad1.addFirst(10);
		// should not be empty
		assertFalse("lld1 should contain 1 item", ad1.isEmpty());

		ad1.removeFirst();
		// should be empty
		assertTrue("lld1 should be empty after removal", ad1.isEmpty());

    }

    @Test
    /* Tests removing from an empty deque */
    public void removeEmptyTest() {

        ArrayDeque<Integer> ad1 = new ArrayDeque<>();
        ad1.addFirst(3);
        ad1.removeLast();
        ad1.removeFirst();
        ad1.removeLast();
        ad1.removeFirst();

        int size = ad1.size();
        String errorMsg = "  Bad size returned when removing from empty deque.\n";
        errorMsg += "  student size() returned " + size + "\n";
        errorMsg += "  actual size() returned 0\n";

        assertEquals(errorMsg, 0, size);

    }

    @Test
    /* Check if you can create ArrayDeque s with different parameterized types*/
    public void multipleParamTest() {

        ArrayDeque<String>  ad1 = new ArrayDeque<>();
        ArrayDeque<Double>  ad2 = new ArrayDeque<Double>();
        ArrayDeque<Boolean> ad3 = new ArrayDeque<Boolean>();

        ad1.addFirst("string");
        ad2.addFirst(3.14159);
        ad3.addFirst(true);

        String s = ad1.removeFirst();
        double d = ad2.removeFirst();
        boolean b = ad3.removeFirst();

    }

    @Test
    /* check if null is return when removing from an empty LinkedListDeque. */
    public void emptyNullReturnTest() {

        ArrayDeque<Integer> ad1 = new ArrayDeque<Integer>();

        boolean passed1 = false;
        boolean passed2 = false;
        assertNull("Should return null when removeFirst is called on an empty Deque,", ad1.removeFirst());
        assertNull("Should return null when removeLast is called on an empty Deque,", ad1.removeLast());

    }

    @Test
    /* Add large number of elements to deque; check if order is correct. */
    public void bigLLDequeTest() {

        ArrayDeque<Integer> ad1 = new ArrayDeque<Integer>();
        for (int i = 0; i < 10; i++) {
            ad1.addLast(i);
        }

        for (double i = 0; i < 5; i++) {
            assertEquals("Should have the same value", i, (double) ad1.removeFirst(), 0.0);
        }

        for (double i = 9; i > 5; i--) {
            assertEquals("Should have the same value", i, (double) ad1.removeLast(), 0.0);
        }

    }

    /**
     * Tests for .get()*/
    @Test
    public void getTest(){


        ArrayDeque<Integer> ad1 = new ArrayDeque<>();
        for (int i = 0; i < 10; i++){
            ad1.addLast(i);
        }

        for (int i = 0; i < 10; i++){
            assertEquals(i, (int)ad1.get(i));
        }

        assertEquals(10, (int)ad1.size());
    }


    /**
     * Tests for .iterator()*/
    @Test
    public void iteratorTest(){


        ArrayDeque<Character> ad1 = new ArrayDeque<>();
        for (char a = 'a'; a <= 'n'; a++) {
            ad1.addLast(a);
        }
        String result = "";
        Iterator<Character> iter1 = ad1.iterator();
        while (iter1.hasNext()) {
            result += iter1.next();
        }

        assertEquals("abcdefghijklmn", result);

    }

    /**
     * Tests for .equals()*/
    @Test
    public void equalsTest(){


        ArrayDeque<Character> ad1 = new ArrayDeque<>();
        LinkedListDeque<Character> lld1 = new LinkedListDeque<>();
        for (char a = 'a'; a <= 'n'; a++) {
            ad1.addLast(a);
            lld1.addLast(a);
        }

        assertTrue(ad1.equals(lld1));
        assertTrue(lld1.equals(ad1));

    }





}

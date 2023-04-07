package randomizedtest;

import edu.princeton.cs.introcs.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
  @Test
  public void testThreeAddThreeRemove1(){
      AListNoResizing<Integer> AListNoR = new AListNoResizing<>();
      BuggyAList<Integer> BuggyAL = new BuggyAList<>();
      AListNoR.addLast(3);
      BuggyAL.addLast(3);
      AListNoR.addLast(6);
      BuggyAL.addLast(6);
      AListNoR.addLast(9);
      BuggyAL.addLast(9);
      int a2 = AListNoR.removeLast();
      int b2 = BuggyAL.removeLast();
      int a1 = AListNoR.removeLast();
      int b1 = BuggyAL.removeLast();
      int a0 = AListNoR.removeLast();
      int b0 = BuggyAL.removeLast();

      assertEquals(AListNoR.size(), BuggyAL.size());

      assertEquals(a2,b2);
      assertEquals(a1,b1);
      assertEquals(a0,b0);
  }

  @Test
  public void randomizedTest(){
      AListNoResizing<Integer> L = new AListNoResizing<>();
      BuggyAList<Integer> LB = new BuggyAList<>();
      int N = 5000;
      for (int i = 0; i < N; i += 1) {
          int operationNumber = StdRandom.uniform(0, 4);
          if (operationNumber == 0) {
              // addLast
              int randVal = StdRandom.uniform(0, 100);
              L.addLast(randVal);
              LB.addLast(randVal);
          } else if (operationNumber == 1) {
              // size
              int size = L.size();
              int sizeB = LB.size();
              assertEquals(size, sizeB);
          } else if (operationNumber == 2) {
              // getLast
              if (L.size() == 0 || LB.size() == 0){
                  continue;
              }
              int ranLast = L.getLast();
              int ranLastB = LB.getLast();
              assertEquals(ranLast, ranLastB);
          } else if (operationNumber == 3) {
              // removeLast
              if (L.size() == 0 || LB.size() == 0){
                  continue;
              }
              int removedLast = L.removeLast();
              int removedLastB = LB.removeLast();
              assertEquals(removedLast, removedLastB);
          }


      }

  }


}

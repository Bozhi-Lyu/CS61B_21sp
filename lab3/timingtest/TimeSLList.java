package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void timeGetLast() {
        // TODO: YOUR CODE HERE
        // The 1st column N, the size of the AList.
        AList<Integer> Ns = new AList();
        Ns.addLast(1000); // the size of the first AList.
        int m = 10000; //Perform M getLast operations on the SLList.
        for(int i = 0; i < 7; i++){
            Ns.addLast(2 * Ns.getLast());
        }

        // The 2nd column time(s)
        AList<Double> times = new AList<>();
        for (int i = 0; i < Ns.size(); i++){
            int num = Ns.get(i);
            SLList<Integer> testAList = new SLList<>();
            for (int j = 0; j < num; j++){
                testAList.addFirst(6);
            }

            Stopwatch st = new Stopwatch();
            for (int j = 0; j < m; j++){
                testAList.getLast();
            }
            double timeInSeconds = st.elapsedTime();

            times.addLast(timeInSeconds);
        }

        // The 3rd column ops, which in this case is constant 10000.
        AList<Integer> ops = new AList<>();
        for (int i = 0; i < Ns.size(); i++){
            ops.addLast(m);
        }

        printTimingTable(Ns, times, ops);
    }

}

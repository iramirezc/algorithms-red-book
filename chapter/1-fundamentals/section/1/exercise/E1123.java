import java.util.Arrays;

import javax.rmi.CORBA.StubDelegate;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Compilation: javac E1123.java
 * Execution: java E1123 <whitelist_file> <operator> < <input_stream>
 *
 * $ java E1123 ./data/whitelist.txt + < ./data/targets.txt
 * 12
 * 57
 * 33
 * 16
 * 29
 * 12
 * 33
 * 33
 *
 * $ java E1123 ./data/whitelist.txt - < ./data/targets.txt
 * 84
 * 48
 * 68
 * 10
 * 18
 * 98
 * 23
 * 54
 * 77
 * 11
 */

/**
 * E1123. Binary Search + (not in the whitelist) - (in the whitelist)
 */
public class E1123 {

  public static int indexOf(int[] a, int target) {
    return indexOf(a, target, 0, a.length - 1);
  }

  public static int indexOf(int[] a, int target, int lo, int hi) {
    if (lo > hi)
      return -1;
    int mid = lo + (hi - lo) / 2;
    if (a[mid] > target) {
      return indexOf(a, target, lo, mid - 1);
    } else if (a[mid] < target) {
      return indexOf(a, target, mid + 1, hi);
    } else {
      return mid;
    }
  }

  public static void main(String[] args) throws Exception {
    if (args.length != 2) {
      throw new Error("You must provide the path to the whitelist and the control operator: <whitelist> <+/->");
    }
    In in = new In(args[0]);
    String sense = args[1];

    int[] whitelist = in.readAllInts();

    Arrays.sort(whitelist);

    while (!StdIn.isEmpty()) {
      int key = StdIn.readInt();
      int index = indexOf(whitelist, key);
      // not in the whitelist
      if (sense.equals("+") && index == -1) {
        StdOut.println(key);
        // in the whitelist
      } else if (sense.equals("-") && index != -1) {
        StdOut.println(key);
      }
    }
  }
}
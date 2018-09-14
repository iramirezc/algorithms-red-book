import java.util.Arrays;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * BinarySearch
 */
public class Exercise_1_1_29 {
  public static int indexOf(int[] a, int key) {
    int lo = 0;
    int hi = a.length - 1;

    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      if (key < a[mid])
        hi = mid - 1;
      else if (key > a[mid])
        lo = mid + 1;
      else
        return mid;
    }
    return -1;
  }

  /**
   * Returns the number of elements that are smaller than the `key` in the sorted
   * array `a`.
   */
  public static int rank(int[] a, int key) {
    int index = indexOf(a, key);

    if (index == -1)
      return 0;

    while (index >= 0 && a[index] == key) {
      index--;
    }

    return index + 1;
  }

  /**
   * Returns the number of elements equal to `key` in array `a`.
   */
  public static int count(int[] a, int key) {
    int index = indexOf(a, key);

    if (index == -1)
      return 0;

    int count = 1;
    int left = index - 1;
    int right = index + 1;
    int length = a.length;

    // count similar numbers to the left
    while (left >= 0 && a[left] == key) {
      count++;
      left--;
    }

    // count similar numbers to the right
    while (right < length && a[right] == key) {
      count++;
      right++;
    }

    return count;
  }

  public static void main(String[] args) {
    In in = new In(args[0]);
    int[] whitelist = in.readAllInts();
    int key = Integer.parseInt(args[1]);

    Arrays.sort(whitelist);

    int i = rank(whitelist, key);
    int j = count(whitelist, key);

    StdOut.println("Original array: " + Arrays.toString(whitelist));

    StdOut.println("rank: " + i);
    StdOut.println("count: " + j);

    for (int lastIndex = (i + j - 1); i <= lastIndex; i++) {
      StdOut.printf("%d ", whitelist[i]);
    }

    StdOut.println();
  }
}

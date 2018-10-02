import java.util.Arrays;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Compilation: javac Exercise_1_1_35.java
 * Execution: java Exercise_1_1_35 <n>
 *
 * $ java Exercise_1_1_35 10
 * ???
 */

/**
 * Exercise_1_1_35. Dice Simulation
 */
public class Exercise_1_1_35 {
  public static int SIDES = 6;

  public static int[] calculateFrequencies() {
    int[] frequencies = new int[2 * SIDES + 1];

    for (int i = 1; i <= SIDES; i++)
      for (int j = 1; j <= SIDES; j++)
        frequencies[i + j]++;

    return frequencies;
  }

  public static double[] calculateProbability(int[] frequencies) {
    double[] probabilities = new double[2 * SIDES + 1];

    for (int k = 2; k <= 2 * SIDES; k++)
      probabilities[k] = frequencies[k] / 36.0;

    return probabilities;
  }

  public static void main(String[] args) {
    int n = Integer.parseInt(args[0]);

    int[] frequencies = calculateFrequencies();
    double[] probabilities = calculateProbability(frequencies);

    for (int i = 0; i < frequencies.length; i++) {
      StdOut.printf("Sum: %3d Freq: %d P: %f\n", i, frequencies[i], probabilities[i]);
    }

    // TODO: complete simulation
  }
}
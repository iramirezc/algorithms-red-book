import edu.princeton.cs.algs4.StdOut;

/**
 * Compilation: javac E1213.java
 * Execution: java E1213
 *
 * $ java E1213
 * Transaction1: Isaac 2/25/2019 99.99
 * Transaction2: Danni 5/13/2019 10000
 */

/**
 * E1213. Transaction
 */
public class E1213 {
  private static class Transaction {
    private final String who;
    private final Date when;
    private final double amount;

    public Transaction(String who, Date when, double amount) {
      this.who = who;
      this.when = when;
      this.amount = amount;
    }

    public String who() {
      return who;
    }

    public Date when() {
      return when;
    }

    public double amount() {
      return amount;
    }

    public String toString() {
      return who() + " " + when() + " " + amount();
    }
  }

  public static void main(String[] args) {
    Transaction transaction1 = new Transaction("Isaac", new Date(2, 25, 2019), 99.99);
    Transaction transaction2 = new Transaction("Danni", new Date(5, 13, 2019), 10000);

    StdOut.printf("Transaction1: %s\n", transaction1);
    StdOut.printf("Transaction2: %s\n", transaction2);
  }
}
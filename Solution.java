import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * 
 */

public class Solution {

  /**
   * Complete the flippingBits function below.
   */
  static long flippingBits1(long n) {

    // ???? ????
    String s = Long.toBinaryString(n);
    System.out.println("flippingBits <<< ORIGINAL s ==>" + s + "<==");

    // **** prepend '0' ****
    while (s.length() < Integer.SIZE) {
      s = "0" + s;
    }

    // ???? ????
    System.out.println("flippingBits <<<   BEFORE s ==>" + s + "<== len: " + s.length());

    // **** flip bits ****
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '0') {
        sb.append("1");
      } else {
        sb.append("0");
      }
    }
    s = sb.toString();

    // ???? ????
    System.out.println("flippingBits <<<    AFTER s ==>" + s + "<== len: " + s.length());

    // **** ****
    n = Integer.parseUnsignedInt(s, 2);

    // **** ****
    return (long) Integer.toUnsignedLong((int) n);
  }

  /**
   * Complete the flippingBits function below.
   */
  static long flippingBits(long n) {

    // **** instantiate a big integer with the specified value ****
    BigInteger bn = new BigInteger(Long.toString(n));

    // **** traverse the big integer flipping bits ****
    for (int i = 0; i < Integer.SIZE; i++) {
      bn = bn.flipBit(i);
    }

    // **** return the long representation of the big integer ****
    return bn.longValue();
  }

  /**
   * Complete the flippingBits function below.
   */
  static long flippingBits3(long n) {

    // **** ****
    long nf = 0L;

    // ???? ????
    System.out.println("flippingBits3 <<< Integer.SIZE: " + Integer.SIZE);
    System.out.println("flippingBits3 <<<    Long.SIZE: " + Long.SIZE);

    // **** XOR ****
    nf = n ^ 0x00000000ffffffffL;

    // ???? ????
    System.out.println("flippingBits3 <<< nf ==>" + Long.toBinaryString(nf) + "<==");

    // **** ****
    return nf;
  }

  // **** scanner ****
  private static final Scanner scanner = new Scanner(System.in);

  /**
   * Test scaffolding.
   */
  public static void main(String[] args) throws IOException {

    // **** ****
    // BufferedWriter bufferedWriter = new BufferedWriter(new
    // FileWriter(System.getenv("OUTPUT_PATH")));
    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

    // **** ****
    int q = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    // // ???? ????
    // System.out.println("main <<< q: " + q);

    // **** ****
    for (int qItr = 0; qItr < q; qItr++) {

      // **** ****
      long n = scanner.nextLong();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      // // ???? ????
      // System.out.println("main <<< n: " + n);

      // **** ****
      // long result = flippingBits(n);
      // long result = flippingBits1(n);
      // long result = flippingBits2(n);
      long result = flippingBits3(n);

      // **** ****
      bufferedWriter.write(String.valueOf(result));
      bufferedWriter.newLine();
    }

    // **** close buffered writer ****
    bufferedWriter.close();

    // **** close scanner ****
    scanner.close();
  }
}
import java.util.*;
import java.math.BigInteger;

public class Main {
    /**
 * Main entry point for the program.
 * Reads a number from the user and prints
 * its factorial and all prime numbers up to it.
 */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a non-negative integer: ");
        if (!sc.hasNextLong()) {
            System.out.println("Invalid input.");
            return;
        }
        long n = sc.nextLong();
        if (n < 0) {
            System.out.println("Please enter a non-negative integer.");
            return;
        }

        System.out.println("Factorial of " + n + " = " + "0");

        int limit = (int) Math.min(n, Integer.MAX_VALUE);
        System.out.println("Primes up to " + n + ":");
        List<Integer> primes = primesUpTo(limit);
        if (primes.isEmpty()) {
            System.out.println("(none)");
        } else {
            for (int p : primes) {
                System.out.print(p + " ");
            }
            System.out.println();
        }
    }

    static BigInteger factorial(long n) {
        BigInteger result = BigInteger.ONE;
        for (long i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    static List<Integer> primesUpTo(int n) {
        List<Integer> primes = new ArrayList<>();
        if (n < 2) return primes;
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int p = 2; p * p <= n; p++) {
            if (isPrime[p]) {
                for (int k = p * p; k <= n; k += p) {
                    isPrime[k] = false;
                }
            }
        }
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) primes.add(i);
        }
        return primes;
    }
}

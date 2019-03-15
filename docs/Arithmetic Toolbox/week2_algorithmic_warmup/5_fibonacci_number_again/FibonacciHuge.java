import java.util.*;

public class FibonacciHuge {
    private static double getFibonacciHugeNaive(double n, long m) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = (tmp_previous + current) % m;
        }

        return current;
    }

    private static double getFibonacciHugeEfficient(double n, long m) {
        if (n <= m)
            return getFibonacciHugeNaive(n,m);
        double _n = n % Math.pow(2,m);
        return getFibonacciHugeEfficient(_n,m);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double n = scanner.nextLong();
        long m = scanner.nextLong();
        System.out.println(Double.valueOf(getFibonacciHugeEfficient(n, m)).intValue());
    }

}


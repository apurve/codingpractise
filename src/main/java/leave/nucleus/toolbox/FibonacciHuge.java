package leave.nucleus.toolbox;

import org.springframework.util.StopWatch;

import java.math.BigInteger;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class FibonacciHuge {

    private static long getFibonacciHugeNaive(long n, long m) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = (tmp_previous + current);
        }

        return current % m;
    }

    private static long getPisanoLength(long n, long m) {
        long lengthOfPisano = 0;
        if (n <= 1)
            return lengthOfPisano;

           BigInteger previous = BigInteger.ZERO;
        BigInteger current  = BigInteger.ONE;

        for (long i = 0; i < n - 1; ++i) {
            BigInteger tmp_previous = previous;
            previous = current;
            current = (tmp_previous.add(current));
            lengthOfPisano++;
            if(previous.remainder(BigInteger.valueOf(m)).equals(BigInteger.ZERO) && current.remainder(BigInteger.valueOf(m)).equals(BigInteger.ONE))
                return lengthOfPisano;
        }

        return lengthOfPisano;
    }

    private static long getFibonacciHugeEfficient(long n, long m) {
        long pisanoLength = getPisanoLength(n,m);
        return getFibonacciHugeNaive(n%pisanoLength,m);
    }

    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);
        long n = 239;//scanner.nextLong();
        long m = 1000;//
        long startTime = System.currentTimeMillis();
        System.out.println(getFibonacciHugeEfficient(n, m));
        long endTime = System.currentTimeMillis();
        System.out.println((endTime - startTime)/1000);
    }
}

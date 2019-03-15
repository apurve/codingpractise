import java.math.BigInteger;
import java.util.Scanner;

public class CarFueling {

    private static int refills = 0;

    static int computeMinRefills(BigInteger dist, int tank, int[] stops) {
        int currentRefill = 0;
        int lastRefill = 0;
        while(currentRefill < stops.length) {
            lastRefill = currentRefill;
            while (currentRefill < stops.length &&
                    checkRefuelAtNextStop(lastRefill, currentRefill, tank, stops))
                currentRefill++;

            if(currentRefill == lastRefill)
                return -1;
            if(currentRefill <= stops.length)
                refills++;
        }

        return refills;
    }

    private static boolean checkRefuelAtNextStop(int lastRefill, int currentRefill,
                                                 int tank, int[] stops) {
        if(lastRefill > 0) {
            try {
                return stops[currentRefill + 1] - stops[lastRefill] <= tank;
            } catch (ArrayIndexOutOfBoundsException exception) {
                return true;
            }
        } else {
            return stops[currentRefill+1]-0 <= tank;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger dist = scanner.nextBigInteger();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        int stops[] = new int[n];
        for (int i = 1; i < n; i++) {
            stops[i] = scanner.nextInt();
        }
        System.out.println(computeMinRefills(dist, tank, stops));
    }
}

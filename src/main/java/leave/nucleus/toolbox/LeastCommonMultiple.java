package leave.nucleus.toolbox;

import java.util.Scanner;

public class LeastCommonMultiple {

    private static long lcm_naive(int a, int b) {
        for (long l = 1; l <= (long) a * b; ++l)
            if (l % a == 0 && l % b == 0)
                return l;

        return (long) a * b;
    }

    private static int efficient_gcd(int a, int b) {
        if(b==0)
            return a;
        return efficient_gcd(b, a % b);
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int gcd = 1;
        if(a > b)
            gcd = efficient_gcd(a,b);
        else
            gcd = efficient_gcd(b,a);
        System.out.println((Long.valueOf(a)*Long.valueOf(b))/Long.valueOf(gcd));
    }

}

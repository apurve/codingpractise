import java.util.*;

public class GCD {
  private static int gcd_naive(int a, int b) {
    int current_gcd = 1;
    for(int d = 2; d <= a && d <= b; ++d) {
      if (a % d == 0 && b % d == 0) {
        if (d > current_gcd) {
          current_gcd = d;
        }
      }
    }

    return current_gcd;
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
        if(a > b) {
            gcd = efficient_gcd(a,b);
        } else
            gcd = efficient_gcd(b,a);
        System.out.println(gcd);
    }
}

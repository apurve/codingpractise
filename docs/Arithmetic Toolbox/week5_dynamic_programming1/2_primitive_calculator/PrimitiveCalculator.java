import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PrimitiveCalculator {

    private static int[] moveCounts;

    public static List<Integer> optimal_sequence(int n) {

        moveCounts = new int[n];

        for(int i = 1; i < n; i++) {
            if(i%3 == 0 && i%2==0)
                moveCounts[i] = minimum(i/3, i/2, i-1) + 1;
            else if (i%3 == 0)
                moveCounts[i] = minimum(i/3, i-1) + 1;
            else if (i%2 == 0)
                moveCounts[i] = minimum(i/2, i-1) + 1;
            else
                moveCounts[i] = moveCounts[i-1] + 1;
        }

        List<Integer> sequence = new ArrayList<Integer>();
        while (n >= 1) {
            sequence.add(n);
            if (n % 3 == 0 && n % 2 == 0) {
                if(moveCounts[n/3] <= moveCounts[n/2] && moveCounts[n/3] <= moveCounts[n-1])
                    n /= 3;
                else if(moveCounts[n/2] <= moveCounts[n-1])
                    n /= 2;
                else
                    n -= 1;
            } else if (n % 3 == 0) {
                if(moveCounts[n/3] <= moveCounts[n-1])
                    n /= 3;
                else
                    n -= 1;
            }else if (n % 2 == 0) {
                if(moveCounts[n/2] <= moveCounts[n-1])
                    n /= 2;
                else
                    n -= 1;
            }  else {
                n -= 1;
            }
        }
        Collections.reverse(sequence);
        return sequence;
    }

    private static int minimum(int i1, int i2) {
        return moveCounts[i1] < moveCounts[i2] ? moveCounts[i1] : moveCounts[i2];
    }

    private static int minimum(int i3, int i2, int i1) {
        if(moveCounts[i3] <= moveCounts[i2] && moveCounts[i3] <= moveCounts[i1])
            return moveCounts[i3];
        else if(moveCounts[i2] <= moveCounts[i1])
            return moveCounts[i2];
        else
            return moveCounts[i1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> sequence = optimal_sequence(n);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
    }
}
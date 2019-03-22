import java.util.Arrays;
import java.util.Scanner;

public class Knapsack {
    public static int optimalWeight(int W, int[] w) {
        //write you code here
        int[][] knapsackMaxValues = new int[W+1][w.length+1];
        for(int i=1; i<=W; i++) {
            for(int j=1;j<=w.length; j++) {
                int keepItem;
                try {
                    keepItem = w[j-1] + knapsackMaxValues[i-w[j-1]][j-1];
                } catch (ArrayIndexOutOfBoundsException exception) {
                    keepItem = 0;
                }
                int leaveItem;
                try {
                    leaveItem = knapsackMaxValues[i][j-1];
                } catch (ArrayIndexOutOfBoundsException exception) {
                    leaveItem = 0;
                }
                if(keepItem > leaveItem)
                    knapsackMaxValues[i][j] = keepItem;
                else
                    knapsackMaxValues[i][j] = leaveItem;
            }
            //printKnapsack(knapsackMaxValues);
        }

        return knapsackMaxValues[W][w.length];
    }

    private static void printKnapsack(int[][] array) {
        System.out.println(Arrays.deepToString(array));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        System.out.println(optimalWeight(W, w));
    }
}
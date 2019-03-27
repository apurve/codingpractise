package leave.nucleus.toolbox;

import java.util.Arrays;
import java.util.Scanner;

public class PlacingParentheses {

    private static char[] expression;
    private static char[] operators;
    private static char[] operands;
    private static int[][] maximum;
    private static int[][] minimum;


    public static long getMaximValue(String exp) {

        expression = exp.toCharArray();
        operators = new char[(exp.length()/2)];
        operands = new char[(exp.length()/2) + 1];

        for(int i=0; i<expression.length; i++) {
            if(i%2==0)
                operands[i/2] = expression[i];
            else
                operators[i/2] = expression[i];
        }

        maximum = new int[operands.length][operands.length];
        minimum = new int[operands.length][operands.length];

        for(int i=0; i<operands.length; i++) {
            maximum[i][i] = Character.getNumericValue(operands[i]);
            minimum[i][i] = Character.getNumericValue(operands[i]);
        }

        for (int s = 1; s < operands.length; s++) {
            for(int i = 0; i < operands.length - s; i++) {
                int j = i+s;
                int[] minAndMax = minAndMax(i,j);
                minimum[i][j] = minAndMax[0];
                maximum[i][j] = minAndMax[1];
                print(maximum);
            }
        }
        print(maximum);
        print(minimum);
        return maximum[0][maximum.length-1];
    }

    private static int[] minAndMax(int i, int j) {
        int[] minAndMax = new int[2];
        for(int k=i; k<j; k++) {
            int[] evaluation = new int[4];
            evaluation[0] = eval(maximum[i][k], maximum[k+1][j], operators[k]);
            evaluation[1] = eval(maximum[i][k], minimum[k+1][j], operators[k]);
            evaluation[2] = eval(minimum[i][k], maximum[k+1][j], operators[k]);
            evaluation[3] = eval(minimum[i][k], minimum[k+1][j], operators[k]);
            minAndMax[0] = minimum(evaluation);
            minAndMax[1] = maximum(evaluation);
        }
        return minAndMax;
    }

    public static int minimum(int[] evaluation) {
        int minimum = evaluation[0];
        for(int x : evaluation) {
            if(x<minimum)
                minimum=x;
        }
        return minimum;
    }

    public static int maximum(int[] evaluation) {
        int maximum = evaluation[0];
        for(int x : evaluation) {
            if(x>maximum)
                maximum=x;
        }
        return maximum;
    }

    private static int eval(int a, int b, char op) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        } else if (op == '*') {
            return a * b;
        } else {
            assert false;
            return 0;
        }
    }

    private static void print(int[][] array) {
        System.out.println(Arrays.deepToString(array));
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String exp = scanner.next();
        System.out.println(getMaximValue(exp));
    }
}

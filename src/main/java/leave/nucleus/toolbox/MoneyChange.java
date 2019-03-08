package leave.nucleus.toolbox;

import java.util.Scanner;

public class MoneyChange {
    private static int[] values = new int[] {10,5,1};
    private static int getChange(int m) {
        //write your code here
        /*
        * loop until m > 0
        *   choose number of coins with maximum value
        * reduce m by the maximum value available
        * increase number of coins
        * */
        int coins = 0;
        while(m > 0) {
            for(int coinValue : values) {
                coins = coins + m/coinValue;
                m = m%coinValue;
            }
        }
        return coins;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

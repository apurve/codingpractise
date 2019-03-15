package leave.nucleus.toolbox;

import java.util.Scanner;

public class ChangeDP {

    public static int[] denominationsSorted = {1,3,4};

    public static int getCountOfChange(int m, int[] coinsSorted) {
        int[] moneyArray = new int[m+1];
        for(int i=1; i<moneyArray.length; i++) {
            moneyArray[i] = m;
            for(int coin : coinsSorted) {
                if(i-coin >= 0) {
                    int coinsForMoney = moneyArray[i-coin]+1;
                    if (m >= coin && (coinsForMoney < moneyArray[i]))
                        moneyArray[i] = coinsForMoney;
                }
            }
        }

        return moneyArray[m];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getCountOfChange(m, denominationsSorted));
    }
}


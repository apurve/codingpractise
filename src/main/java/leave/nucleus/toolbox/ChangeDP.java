package leave.nucleus.toolbox;

import java.util.Scanner;

public class ChangeDP {

    public static int[] denominationsSorted = {1,3,4};

    public static int getCountOfChange(int moneyNeeded, int[] coinsSorted) {
        int[] moneyArray = new int[moneyNeeded+1];
        for(int i=1; i<moneyArray.length; i++) {
            moneyArray[i] = moneyNeeded;
            for(int coin : coinsSorted) {
                if(i-coin >= 0) {
                    int coinsForMoney = moneyArray[i-coin]+1;
                    if (moneyNeeded >= coin && (coinsForMoney < moneyArray[i]))
                        moneyArray[i] = coinsForMoney;
                }
            }
        }
        return moneyArray[moneyNeeded];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getCountOfChange(m, denominationsSorted));
    }
}


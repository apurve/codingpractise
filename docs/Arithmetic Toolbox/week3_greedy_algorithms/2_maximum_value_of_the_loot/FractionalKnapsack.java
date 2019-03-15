import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class FractionalKnapsack {
    private static BigDecimal getOptimalValue(BigDecimal capacity, List<Item> items) {
        BigDecimal value = BigDecimal.ZERO;
        //write your code here
        Collections.sort(items, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return o2.valePerUnit.compareTo(o1.valePerUnit);
            }
        });

        for (Item item : items) {
            if(capacity.equals(BigDecimal.ZERO))
                return value;
            else if(capacity.compareTo(item.weight) > 0) {
                capacity = capacity.subtract(item.weight);
                value = value.add(item.value);
            } else {
                value = value.add(item.valePerUnit.multiply(capacity));
                capacity = BigDecimal.ZERO;
            }
        }
        return value;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        BigDecimal capacity = scanner.nextBigDecimal();
        List<Item> items = new ArrayList<Item>();
        for (int i = 0; i < n; i++) {
            items.add(new Item(scanner.nextBigDecimal(), scanner.nextBigDecimal()));
        }
        System.out.println(getOptimalValue(capacity, items));
    }

    /*public static void main(String args[]) {
       int n = 1;
        BigDecimal capacity = BigDecimal.valueOf(10);
        List<Item> items = new ArrayList<Item>();
        items.add(new Item(BigDecimal.valueOf(500), BigDecimal.valueOf(30)));
        System.out.println(getOptimalValue(capacity, items));
    }*/

    public static class Item {
        private BigDecimal value;
        private BigDecimal weight;
        private BigDecimal valePerUnit;

        Item (BigDecimal value, BigDecimal weight) {
            this.value = value;
            this.weight = weight;
            this.valePerUnit = value.divide(weight, 10, RoundingMode.UP);
        }
    }

}

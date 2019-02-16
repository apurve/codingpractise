package leave.nucleus.toolbox;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MaximumPairwiseProductTest {

    private FastScanner scanner = null;
    private int n;
    private long[] numbers;

    @Before
    public void initialize() {
        scanner = new FastScanner(System.in);
    }

    private void readInput() {
        n = scanner.nextInt();
        numbers = new long[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
    }

    @Test
    public void testFindMaximumNumber() {
        numbers = new long[] {0, 3, 5, 7, 9, 1};
        MaximumPairwiseProduct.MaximumNumberAndIndex maximumNumberAndIndex = MaximumPairwiseProduct.findMaximumNumber(numbers);
        Assert.assertEquals(9, maximumNumberAndIndex.getMaximumNumber());
    }

    @Test
    public void testFindSecondMaximum() {
        numbers = new long[] {0, 3, 5, 7, 9, 1};
        Assert.assertEquals(7, MaximumPairwiseProduct.findSecondMaximumNumber(numbers, 4));
    }

    @Test
    public void testMaximumPairProduct() {
        long[] maximumPair = new long[] {7, 9};
        numbers = new long[] {5, 3, 5, 7, 9, 1};
        Assert.assertEquals(new MaximumPairwiseProduct.MaximumPair(9, 7),
                MaximumPairwiseProduct.findMaximumPair(numbers));
    }
}

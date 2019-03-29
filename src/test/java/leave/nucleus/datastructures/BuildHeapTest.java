package leave.nucleus.datastructures;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class BuildHeapTest {

    @Test
    public void testGeneratedSwaps1() {
        BuildHeap heap = new BuildHeap();
        heap.setData(new int[] {5,4,3,2,1});
        List<BuildHeap.Swap> swaps = heap.generateSwaps();
        Assert.assertEquals(3, swaps.size());
        Assert.assertEquals(new BuildHeap.Swap(1,4), swaps.get(0));
        Assert.assertEquals(new BuildHeap.Swap(0,1), swaps.get(1));
        Assert.assertEquals(new BuildHeap.Swap(1,3), swaps.get(2));
    }

    @Test
    public void testGeneratedSwaps2() {
        BuildHeap heap = new BuildHeap();
        heap.setData(new int[] {1,2,3,4,5});
        List<BuildHeap.Swap> swaps = heap.generateSwaps();
        Assert.assertEquals(0, swaps.size());
    }

}
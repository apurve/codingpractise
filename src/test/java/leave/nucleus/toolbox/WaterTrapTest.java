package leave.nucleus.toolbox;

import org.junit.Assert;
import org.junit.Test;

public class WaterTrapTest {

    @Test
    public void sampleTestCase() {
        int[][] grid = {
                {0,1,1,0},
                {1,0,1,0},
                {1,0,0,1},
                {1,1,1,1}
        };
        Assert.assertEquals(3, WaterTrap.computeVolumeOfTrappedWater(grid));
    }

    @Test
    public void sampleTestCaseConnectedCornerCell() {
        int[][] grid = {
                {0,1,1,0},
                {1,0,1,0},
                {1,0,0,1},
                {1,0,1,1}
        };
        Assert.assertEquals(0, WaterTrap.computeVolumeOfTrappedWater(grid));
    }

    @Test
    public void sampleNullOrEmptyGrid() {
        Assert.assertEquals(0, WaterTrap.computeVolumeOfTrappedWater(null));
        Assert.assertEquals(0, WaterTrap.computeVolumeOfTrappedWater(new int[0][0]));
    }

    @Test
    public void singleTower() {
        int[][] grid = {
                {1}
        };
        Assert.assertEquals(0, WaterTrap.computeVolumeOfTrappedWater(grid));
    }

    @Test
    public void singleCell() {
        int[][] grid = {
                {0}
        };
        Assert.assertEquals(0, WaterTrap.computeVolumeOfTrappedWater(grid));
    }
}
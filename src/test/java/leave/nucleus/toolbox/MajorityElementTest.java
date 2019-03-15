package leave.nucleus.toolbox;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MajorityElementTest {

    private int[] elements = {2,3,9,2,2};
    private int[] elementsNot = {1,2,3,4};

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testMajority() {
        Assert.assertEquals(1, MajorityElement.getMajorityElement(elements, 0, elements.length));
    }

    @Test
    public void testLackOfMajority() {
        Assert.assertEquals(0, MajorityElement.getMajorityElement(elementsNot, 0, elements.length));
    }
}
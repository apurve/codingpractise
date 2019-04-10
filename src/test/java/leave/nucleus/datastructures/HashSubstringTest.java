package leave.nucleus.datastructures;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class HashSubstringTest {

    @Test
    public void test1() {
        List<Integer> expectedOccurrences = new ArrayList<>();
        expectedOccurrences.add(0);
        expectedOccurrences.add(4);
        List<Integer> occurrences = HashSubstring.getOccurrences(new HashSubstring.Data("aba", "abacaba"));
        Assert.assertEquals(expectedOccurrences , occurrences);
    }

    @Test
    public void test2() {
        List<Integer> expectedOccurrences = new ArrayList<>();
        expectedOccurrences.add(4);
        List<Integer> occurrences = HashSubstring.getOccurrences(new HashSubstring.Data("Test", "testTesttesT"));
        Assert.assertEquals(expectedOccurrences , occurrences);
    }

}
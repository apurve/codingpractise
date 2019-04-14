package leave.nucleus.datastructures;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class HashSubstringTest {

    @Test
    public void testPreComputeHashes() {
        char[] text = "abacaba".toCharArray();
        char[] pattern = "aba".toCharArray();
        long[] hashesFast = HashSubstring.preComputeHashes(text, pattern);
        long[] hashes = new long[text.length - pattern.length + 1];
        for (int i = 0; i + pattern.length <= text.length; ++i) {
            hashes[i] = HashSubstring.hashCode(text, i, pattern.length);
        }
        Assert.assertArrayEquals(hashes, hashesFast);
    }

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

    @Test
    public void test3() {
        List<Integer> expectedOccurrences = new ArrayList<>();
        expectedOccurrences.add(0);
        List<Integer> occurrences = HashSubstring.getOccurrences(new HashSubstring.Data("Test", "Test"));
        Assert.assertEquals(expectedOccurrences , occurrences);
    }

    //@Test
    public void stressTest() {
        boolean testPassed = true; long NANOSEC_PER_SEC = 1000l*1000*1000;
        while (testPassed) {
            int maxTextLength = (int) (Math.random()*1000);
            int maxPatternLength = (int) (Math.random()*500);
            System.out.println("PATTERN LEN : " + maxPatternLength + " TEXT LEN : "+ maxTextLength);
            long startTime = System.nanoTime();
            while ((System.nanoTime()-startTime)< 1*60*NANOSEC_PER_SEC) {
                String text = getAlphaNumericString((int ) (Math.random() * maxTextLength));
                String pattern = getAlphaNumericString((int ) (Math.random() * maxPatternLength));
                List<Integer> slowOccurrences = HashSubstringSlow.getOccurrences(new HashSubstringSlow.Data(pattern, text));
                List<Integer> fastOccurrences = HashSubstring.getOccurrences(new HashSubstring.Data(pattern, text));
                if(slowOccurrences.size() != fastOccurrences.size()) {
                    testPassed = false;
                    System.out.println("TEXT : "+text);
                    System.out.println("PATTERN : "+pattern);
                    Assert.assertEquals(slowOccurrences, fastOccurrences);
                }
            }
        }
    }

    private String getAlphaNumericString(int n) {
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {
            int index
                    = (int)(AlphaNumericString.length()
                    * Math.random());
            sb.append(AlphaNumericString
                              .charAt(index));
        }
        return sb.toString();
    }

}

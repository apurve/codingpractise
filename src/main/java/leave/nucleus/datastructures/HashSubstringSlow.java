package leave.nucleus.datastructures;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class HashSubstringSlow {

    private static FastScanner in;
    private static PrintWriter out;
    private static int shiftBy = 5;
    private static long bigPrime = 10000001969l;

    public static void main(String[] args) throws IOException {
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        printOccurrences(getOccurrences(readInput()));
        out.close();
    }

    private static Data readInput() throws IOException {
        String pattern = in.next();
        String text = in.next();
        return new Data(pattern, text);
    }

    private static void printOccurrences(List<Integer> ans) throws IOException {
        for (Integer cur : ans) {
            out.print(cur);
            out.print(" ");
        }
    }

    public static List<Integer> getOccurrences(Data input) {
        List<Integer> occurrences = new ArrayList<Integer>();
        char[] pattern = input.pattern.toCharArray(), text = input.text.toCharArray();
        int patternLength = pattern.length, textLength = text.length;
        long patternHash = hashCode(pattern, 0, patternLength);

        if(patternLength <= textLength){
            long[] hashes = preComputeHashes(text, pattern);
            for (int i = 0; i + patternLength <= textLength; ++i) {
                if (patternHash == hashes[i] &&
                        compareByCharacter(text, pattern, patternLength, i))
                    occurrences.add(i);
            }
        }
        return occurrences;
    }

    private static boolean compareByCharacter(char[] text, char[] pattern, int patternLength, int i){
        boolean equal = true;
        for (int j = 0; j < patternLength; ++j) {
            if (pattern[j] != text[i + j]) {
                equal = false;
                break;
            }
        }
        return equal;
    }

    public static long[] preComputeHashes(char[] text, char[] pattern) {
        long[] hashes = new long[text.length - pattern.length + 1];
        //hashes[hashes.length - 1] = hashCode(text, hashes.length - 1, pattern.length);

        long hash = 0, multiplier = 3, previousHash;
        int power = 0;
        for (int i = pattern.length - 1; i >= 0; i--) {
            hash += text[i] * ((long) Math.pow(multiplier, power));
            power++;
        }
        previousHash = hash;

        for (int i = 1; i < hashes.length; i++) {
            hash = 0;
            hash += (previousHash* multiplier) - text[i-1] * ((long) Math.pow(multiplier, power)) + text[i+pattern.length-1];

            hashes[i-1] = previousHash % bigPrime;
            previousHash = hash;
        }
        hashes[hashes.length-1] = previousHash % bigPrime;
        return hashes;
    }

    public static long hashCode(char[] text, int offset, int count) {
        long hashCode = 0;
        if (hashCode == 0) {
            long hash = 0;
            int power = 0, multiplier = 3;
            for (int i = offset + count - 1; i >= offset; i--) {
                hash += text[i] * ((long) Math.pow(multiplier, power));
                power++;
            }
            hashCode = hash % bigPrime;
        }
        return hashCode;
    }

    static class Data {
        String pattern;
        String text;
        public Data(String pattern, String text) {
            this.pattern = pattern;
            this.text = text;
        }
    }

    static class FastScanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
        }

        public String next() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}

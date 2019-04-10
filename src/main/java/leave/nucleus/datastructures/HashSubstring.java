package leave.nucleus.datastructures;

import java.io.*;
import java.util.*;

public class HashSubstring {

    private static FastScanner in;
    private static PrintWriter out;
    private static int shiftBy = 5;

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
        char[] pattern = input.pattern.toCharArray(), text = input.text.toCharArray();
        int patternLength = pattern.length, textLength = text.length;
        int patternHash = hashCode(pattern, 0, patternLength);
        int[] hashes = preComputeHashes(text, pattern);
        List<Integer> occurrences = new ArrayList<Integer>();
        for (int i = 0; i + patternLength <= textLength; ++i) {
            if (patternHash == hashes[i])
                occurrences.add(i);
        }
        return occurrences;
    }

    private static int[] preComputeHashes(char[] text, char[] pattern) {
        int[] hashes = new int[text.length - pattern.length + 1];
        hashes[hashes.length - 1] = hashCode(text, hashes.length - 1, pattern.length);
        int hash = 0, multiplier = 1;
        for (int i = text.length; i >= 0; i--) {
            hash += text[i] * multiplier;
            int shifted = multiplier << shiftBy;
            multiplier = shifted - multiplier;
            hashes[i] = hash;
        }
        return hashes;
    }

    private static int hashCode(char[] text, int offset, int count) {
        int hashCode = 0;
        if (hashCode == 0) {
            int hash = 0, multiplier = 1;
            for (int i = offset + count - 1; i >= offset; i--) {
                hash += text[i] * multiplier;
                int shifted = multiplier << shiftBy;
                multiplier = shifted - multiplier;
            }
            hashCode = hash;
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


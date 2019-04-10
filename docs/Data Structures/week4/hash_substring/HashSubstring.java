import java.io.*;
import java.util.*;

public class HashSubstring {

    private static FastScanner in;
    private static PrintWriter out;

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

    private static List<Integer> getOccurrences(Data input) {
        char[] pattern = input.pattern.toCharArray(), text = input.text.toCharArray();
        int patternLength = pattern.length, textLength = text.length;
        int patternHash = hashCode(pattern);
        int[] hashes = new int[textLength];
        List<Integer> occurrences = new ArrayList<Integer>();
        for (int i = 0; i + patternLength <= textLength; ++i) {
            if (patternHash == hashCode(text, i, patternLength))
                occurrences.add(i);
        }
        return occurrences;
    }

    private static int hashCode(char[] pattern) {
        int hash = 0;
        for (int i = pattern.length - 1; i >= 0; i--) {
            hash += pattern[i];
        }
        return hash;
    }

    private static int hashCode(char[] text, int offset, int count) {
        int hash = 0;
        for (int i = offset + count - 1; i >= offset; i--) {
            hash += text[i];
        }
        return hash;
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


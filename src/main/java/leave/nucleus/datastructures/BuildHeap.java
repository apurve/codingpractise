package leave.nucleus.datastructures;

import java.io.*;
import java.util.*;

public class BuildHeap {

    public void setData(int[] data) {
        this.data = data;
    }

    private int[] data;
    private FastScanner in;
    private PrintWriter out;

    public static void main(String[] args) throws IOException {
        new BuildHeap().solve();
    }

    private void readData() throws IOException {
        int n = in.nextInt();
        data = new int[n];
        for (int i = 0; i < n; ++i) {
            data[i] = in.nextInt();
        }
    }

    private void writeResponse(List<Swap> swaps) {
        out.println(swaps.size());
        for (Swap swap : swaps) {
            out.println(swap.index1 + " " + swap.index2);
        }
    }

    public List<Swap> generateSwaps() {
        List<Swap> swaps = new ArrayList<Swap>();
        for(int i = data.length/2; i >= 0; i--) {
            shiftDown(swaps, i);
        }
        return swaps;
    }

    private void shiftDown(List<Swap> swaps, int i) {
        int minIndex = i;
        int leftChildIndex = (2*i)+1;
        int rightChildIndex = (2*i)+2;
        if(leftChildIndex < data.length && data[leftChildIndex] < data[minIndex])
            minIndex = leftChildIndex;
        if(rightChildIndex < data.length && data[rightChildIndex] < data[minIndex])
            minIndex = rightChildIndex;
        if(minIndex != i) {
            swapAndAdd(swaps, i, minIndex);
            shiftDown(swaps, minIndex);
        }
    }

    private void swapAndAdd(List<Swap> swaps, int i, int j) {
        swaps.add(new Swap(i, j));
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }

    public void solve() throws IOException {
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        readData();
        writeResponse(generateSwaps());
        out.close();
    }

    static class Swap {
        int index1;
        int index2;

        public Swap(int index1, int index2) {
            this.index1 = index1;
            this.index2 = index2;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Swap)) return false;
            Swap swap = (Swap) o;
            return index1 == swap.index1 &&
                    index2 == swap.index2;
        }

        @Override
        public int hashCode() {
            return Objects.hash(index1, index2);
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
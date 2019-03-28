package leave.nucleus.datastructures;

import java.util.*;
import java.io.*;

public class StackWithMax {
    class FastScanner {
        StringTokenizer tok = new StringTokenizer("");
        BufferedReader in;

        FastScanner() {
            in = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (!tok.hasMoreElements())
                tok = new StringTokenizer(in.readLine());
            return tok.nextToken();
        }
        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }

    public void solve() throws IOException {
        FastScanner scanner = new FastScanner();
        int queries = scanner.nextInt();
        Stack<Integer> stack = new Stack<Integer>();
        Stack<Integer> maxIndex = new Stack<Integer>();
        for (int qi = 0; qi < queries; ++qi) {
            String operation = scanner.next();
            if ("push".equals(operation)) {
                int value = scanner.nextInt();
                stack.push(value);
                if(maxIndex.isEmpty()) {
                    maxIndex.push(stack.size()-1);
                } else if(value >= stack.elementAt(maxIndex.peek())) {
                    maxIndex.push(stack.size()-1);
                }
            } else if ("pop".equals(operation)) {
                if(stack.elementAt(maxIndex.peek()) == stack.pop())
                    maxIndex.pop();
            } else if ("max".equals(operation)) {
                System.out.println(stack.elementAt(maxIndex.peek()));
            }
        }
    }

    static public void main(String[] args) throws IOException {
        new StackWithMax().solve();
    }
}
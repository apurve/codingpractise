import java.util.*;
import java.io.*;

public class MajorityElement {
    public static int getMajorityElement(int[] a, int left, int right) {
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();
        for(int x : a) {
            if(count.containsKey(x))
                count.put(x, count.get(x)+1);
            else
                count.put(x,1);
        }

        for(Map.Entry<Integer,Integer> entry : count.entrySet()) {
            if(entry.getValue() > a.length/2) {
                return 1;
            }
        }
        //write your code here
        return 0;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(getMajorityElement(a, 0, a.length));
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}


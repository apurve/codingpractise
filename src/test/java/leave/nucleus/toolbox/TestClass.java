package leave.nucleus.toolbox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class TestClass {

    static int solve(String s) {
        int maxDistance = 0;
        if(s == null) {
            return maxDistance;
        } else if(s.length() == 0) {
            return maxDistance;
        }
        boolean clockWise = false;
        for (char c: s.toCharArray()) {
            if(c == 'A') {
                if(!clockWise)
                maxDistance++;

            } else if(c == 'C') {
                maxDistance++;
            } else {
                maxDistance++;
            }
        }

        return maxDistance;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        String temp[] = br.readLine().trim().split(" ");
        int M = Integer.parseInt(temp[0]);
        int N = Integer.parseInt(temp[1]);
        String[] grid = new String[M];
        for (int i_grid = 0; i_grid < M; i_grid++) {
            grid[i_grid] = br.readLine();
        }
        int out_ = volume_trapped(M, N, grid);
        wr.println(out_);

        wr.close();
        br.close();
    }

    static int volume_trapped(int m, int n, String[] grid) {
        int maxWater = 0;
        //int [][] grid = createGrid(m,n,gridS);
        /* From each filled cell, find the largest region from that cell */
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row].charAt(col) == '.') {
                    int size = findLargestRegion(grid, row, col, m, n);
                    maxWater = Math.max(maxWater, size);
                }
            }
        }

        return maxWater;
    }

    private static int findLargestRegion(String[] grid, int row, int col, int m , int n) {
        /* Pro tip: put boundary checks at top of recursive call,
                    instead of before doing recursive call */
        StringBuilder string = new StringBuilder(grid[row]);
        string.setCharAt(col, '*');
        grid[row] = string.toString(); // we alter the original matrix here

        if (row < 0 || row >= m || col < 0 || col >= n) {
            return 0;
        } else if (grid[row].charAt(col) == '*') {
            return 0;
        }


        int size = 1;       // 1 accounts for our size

        /* Accounts recursively for neighbors sizes */
        for (int r = row - 1; r <= row + 1; r++) {
            for (int c = col - 1; c <= col + 1; c++) {
                    size += findLargestRegion(grid, r, c, m, n);
            }
        }

        return size;
    }
}

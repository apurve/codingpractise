package leave.nucleus.toolbox;

import java.util.ArrayList;
import java.util.List;

public class WaterTrap {

    private static int TOWER = 1;

    public static int computeVolumeOfTrappedWater(int[][] grid) {
        if(grid == null)
            return 0;
        else if(grid.length == 0)
            return 0;
        int volumeOfWater = 0;
        boolean[][] visited = new boolean[grid.length][grid.length];
        for(int row = 0; row < grid.length; row++) {
            for(int col = 0; col < grid.length; col++) {
                if(!isEdgeCell(grid, row, col) && grid[row][col] != TOWER && !visited[row][col]) {
                    Cell visiting = new Cell(row,col);
                    List<Cell> connectedCells = new ArrayList<Cell>();
                    connectedCells.add(visiting);
                    computeVolumeOfConnectedCells(grid, visited, connectedCells, visiting);
                    if(connectedCells != null)
                        volumeOfWater += connectedCells.size();
                }
            }
        }
        return volumeOfWater;
    }

    private static void computeVolumeOfConnectedCells(int[][] grid, boolean[][] visited, List<Cell> connectedCells, Cell visiting) {
        if(isAnyNeighbourEdgeCell(grid, visiting)) {
            connectedCells.clear();
        }
        visited[visiting.row][visiting.col] = true;
        if(visiting.row-1 > 0) exploreAdjacentCell(grid, visited, visiting.row-1, visiting.col, connectedCells);
        if(visiting.row+1 < grid.length) exploreAdjacentCell(grid, visited, visiting.row+1, visiting.col, connectedCells);
        if(visiting.col-1 > 0) exploreAdjacentCell(grid, visited, visiting.row, visiting.col-1, connectedCells);
        if(visiting.col+1 < grid.length) exploreAdjacentCell(grid, visited, visiting.row, visiting.col+1, connectedCells);
    }

    private static void exploreAdjacentCell(int[][] grid, boolean[][] visited, int row, int col, List<Cell> connectedCells) {
        if(grid[row][col] != TOWER && !visited[row][col]) {
            visited[row][col] = true;
            if(connectedCells.size() > 0)
                connectedCells.add(new Cell(row, col));
            computeVolumeOfConnectedCells(grid, visited, connectedCells, new Cell(row, col));
        }
    }

    private static boolean isAnyNeighbourEdgeCell(int[][] grid, Cell visiting) {
        if(visiting.row-1 > 0 && grid[visiting.row-1][visiting.col] != TOWER && isEdgeCell(grid, visiting.row-1, visiting.col)) return true;
        if(visiting.row+1 < grid.length && grid[visiting.row+1][visiting.col] != TOWER && isEdgeCell(grid, visiting.row+1, visiting.col)) return true;
        if(visiting.col-1 > 0 && grid[visiting.row][visiting.col-1] != TOWER && isEdgeCell(grid, visiting.row, visiting.col-1)) return true;
        if(visiting.col+1 < grid.length && grid[visiting.row][visiting.col+1] != TOWER && isEdgeCell(grid, visiting.row, visiting.col+1)) return true;
        return false;
    }

    private static boolean isEdgeCell(int[][] grid, int row, int col) {
        return row == 0 || col ==0 ||
                row == grid.length - 1 || col == grid.length - 1;
    }

    static class Cell {
        int row;
        int col;
        public Cell(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}

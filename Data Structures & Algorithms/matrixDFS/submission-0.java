class Solution {
    public int countPaths(int[][] grid) {
        return dfs(grid, 0, 0, new int[grid.length][grid[0].length]);
    }

    /*
     * Here are the 4 base conditions for traversing through the grid
     * 1. Traversal cannot go less than the min row/column length - r<0 || c<0
     * 2. Traversal cannot go over the max row/column length - r>=grid.length || c>=grid[0].length
     * 3. If the cell is already traversed - visit[r][c] == 1
     * 4. If the cell is a rock - grid[r][c] == 1
     */
    private static int dfs(int[][] grid, int r, int c, int[][] visit) {
        int rowLen = grid.length;
        int colLen = grid[0].length;
        if (
            (r < 0 || c < 0) ||
            (r >= rowLen || c >= colLen) ||
            visit[r][c] == 1 ||
            grid[r][c] == 1
        ) {
            return 0;
        }
        if (r == rowLen - 1 && c == colLen - 1) {
            return 1;
        }
        visit[r][c] = 1;
        int count = 0;
        count = count + dfs(grid, r + 1, c, visit);
        count = count + dfs(grid, r - 1, c, visit);
        count = count + dfs(grid, r, c + 1, visit);
        count = count + dfs(grid, r, c - 1, visit);

        visit[r][c] = 0;
        return count;
    }
}

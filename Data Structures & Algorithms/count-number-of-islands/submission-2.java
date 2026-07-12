class Solution {
    public int numIslands(char[][] grid) {
        int rowLen = grid.length;
        int colLen = grid[0].length;
        int islands = 0;
        int[][] visit = new int[grid.length][grid[0].length];
        for (int r = 0; r <= rowLen - 1; r++) {
            for (int c = 0; c <= colLen - 1; c++) {
                if (grid[r][c] == '1' && visit[r][c] == 0) {
                    dfs(grid, r, c, visit);
                    islands++;
                }
            }
        }
        return islands;
    }

    private static void dfs(char[][] grid, int r, int c, int[][] visit) {
        if (!baseCondition(grid, r, c, visit)) {
            return;
        }
        if (mainCondition(grid, r, c)) {
            return;
        }
        visit[r][c] = 1;
        dfs(grid, r + 1, c, visit);
        dfs(grid, r - 1, c, visit);
        dfs(grid, r, c + 1, visit);
        dfs(grid, r, c - 1, visit);
    }

    /*
     * 1. Should not go under bounds
     * 2. Should not go over bounds
     * 3. Should not be visited
     * 4. Should be a land
     */
    private static boolean baseCondition(char[][] grid, int r, int c, int[][] visit) {
        int rowLen = grid.length;
        int colLen = grid[0].length;
        if (Math.min(r, c) < 0 ||
                (r >= rowLen || c >= colLen) ||
                visit[r][c] == 1
        ) {
            return false;
        }
        return true;
    }

    private static boolean mainCondition(char[][] grid, int r, int c) {
        return grid[r][c] == '0';
    }
}

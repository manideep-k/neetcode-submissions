class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int rowLen = grid.length;
        int colLen = grid[0].length;
        int[][] visit = new int[rowLen][colLen];
        int max = 0;
        for (int r = 0; r <= rowLen - 1; r++) {
            for (int c = 0; c <= colLen - 1; c++) {
                if (grid[r][c] == 1 && visit[r][c] != 1) {
                    max = Math.max(max, dfs(grid, r, c, visit));
                }
            }
        }
        return max;
    }

    private static int dfs(int[][] grid, int r, int c, int[][] visit) {
        if (!baseCondition(grid, r, c, visit)) {
            return 0;
        }
        visit[r][c] = 1;
        int count = 1;
        count = count + dfs(grid, r + 1, c, visit);
        count = count + dfs(grid, r - 1, c, visit);
        count = count + dfs(grid, r, c + 1, visit);
        count = count + dfs(grid, r, c - 1, visit);
        return count;
    }

    private static boolean baseCondition(int[][] grid, int r, int c, int[][] visit) {
        int rowLen = grid.length;
        int colLen = grid[0].length;
        if (Math.min(r, c) < 0 ||
                (r >= rowLen || c >= colLen) ||
                visit[r][c] == 1 ||
                grid[r][c] == 0
        ) {
            return false;
        }
        return true;
    }
}

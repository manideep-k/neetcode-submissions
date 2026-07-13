class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        // Question mentioned 8-directional search
        final int[][] neighbours = new int[][]{
                {1, 0},
                {-1, 0},
                {0, 1},
                {0, -1},
                {1, 1},
                {1, -1},
                {-1, 1},
                {-1, -1}
        };
        final int ROWS = grid.length;
        final int COLUMNS = grid[0].length;

        if (grid[0][0] == 1 || grid[ROWS - 1][COLUMNS - 1] == 1) {
            return -1;
        }
        int[][] visit = new int[ROWS][COLUMNS];
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0});
        visit[0][0] = 1;
        int distance = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i <= size - 1; i++) {
                int[] cell = queue.removeFirst();
                int r = cell[0];
                int c = cell[1];
                if (r == ROWS - 1 && c == COLUMNS - 1) {
                    return distance;
                }

                for (int[] neighbour : neighbours) {
                    int newR = r + neighbour[0];
                    int newC = c + neighbour[1];
                    if (!baseCondition(grid, newR, newC, visit)) {
                        continue;
                    }
                    System.out.printf("[%d,%d] clearPath++\n", newR, newC);
                    queue.add(new int[]{newR, newC});
                    visit[newR][newC] = 1;
                }
            }
            distance = distance + 1;
        }

        return -1;
    }

    private static boolean baseCondition(int[][] grid, int r, int c, int[][] visit) {
        final int ROWS = grid.length;
        final int COLUMNS = grid[0].length;
        if (Math.min(r, c) < 0 ||
                (r >= ROWS || c >= COLUMNS) ||
                visit[r][c] == 1 ||
                grid[r][c] == 1
        ) {
            return false;
        }
        return true;
    }

}
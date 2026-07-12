class Solution {
    public int shortestPath(int[][] grid) {
        // Calculate the length of the grid
        int ROWS = grid.length;
        int COLS = grid[0].length;
        int[][] neighbours = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        int[][] visit = new int[ROWS][COLS];
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0});
        visit[0][0] = 1;

        int length = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i <= size - 1; i++) {
                int[] cell = queue.removeFirst();
                int r = cell[0];
                int c = cell[1];
                // Reached bottom-right
                if (r == ROWS - 1 && c == COLS - 1) {
                    return length;
                }
                for (int[] neighbour : neighbours) {
                    int newR = r + neighbour[0];
                    int newC = c + neighbour[1];
                    /*
                     * 1. Should not be under bounds
                     * 2. Should not be over bounds
                     * 3. Should not be visited
                     * 4. Should be a valid grid path
                     */
                    if (Math.min(newR, newC) < 0 ||
                            (newR >= ROWS || newC >= COLS) ||
                            visit[newR][newC] == 1 ||
                            grid[newR][newC] == 1
                    ) {
                        continue;
                    }
                    queue.add(new int[]{newR, newC});
                    visit[newR][newC] = 1;
                }
            }
            length++;
        }
        return -1;
    }
}

class Solution {
    public int shortestPath(int[][] grid) {
        // Calculate the length of the grid
        int ROWS = grid.length;
        int COLS = grid[0].length;
        // Neighbors value to calculate the coordinates dynamically. This is final and should never be modified.
        final int[][] neighbours = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        // Visit cache to mark the visited COORDINATES
        int[][] visit = new int[ROWS][COLS];

        // Queue contains the coordinates of grid and NOT THE GRID VALUES!!!
        Deque<int[]> queue = new ArrayDeque<>();

        // Adding the top-left element to the queue and marking it as visited to start the execution
        queue.add(new int[]{0, 0});
        visit[0][0] = 1;

        int length = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            // This is exactly similar to how we are doing BFS for binary-trees.
            // This is so that we calculate things based on the level.
            // In binary trees, the left and right are added to the queue, whereas here the coordinates are added.
            for (int i = 0; i <= size - 1; i++) {
                int[] cell = queue.removeFirst();
                int r = cell[0];
                int c = cell[1];
                // Reached bottom-right, so the shortest path length can be returned
                if (r == ROWS - 1 && c == COLS - 1) {
                    return length;
                }
                // Similar to Matrix DFS, we do [r + 1, c], [r - 1, c], [r, c + 1], [r, c - 1]
                // In DFS we do it using a recursion, here we are doing it using for loop and calculating the new row and column
                for (int[] neighbour : neighbours) {
                    int newR = r + neighbour[0];
                    int newC = c + neighbour[1];
                    if (baseCondition(grid, newR, newC, ROWS, COLS, visit)
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

    private static boolean baseCondition(int[][] grid, int newR, int newC, int ROWS, int COLS, int[][] visit) {
        /*
         * 1. Should not be under bounds
         * 2. Should not be over bounds
         * 3. Should not be visited
         * 4. Should be a valid grid path
         */
        return Math.min(newR, newC) < 0 ||
                (newR >= ROWS || newC >= COLS) ||
                visit[newR][newC] == 1 ||
                grid[newR][newC] == 1;
    }
}

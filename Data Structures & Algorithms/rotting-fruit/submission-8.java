class Solution {
    public int orangesRotting(int[][] grid) {
        final int[][] neighbours = new int[][]{
                {1, 0},
                {-1, 0},
                {0, 1},
                {0, -1}
        };
        final int ROWS = grid.length;
        final int COLS = grid[0].length;
        
        Deque<int[]> queue = new ArrayDeque<>();
        // This is nothing but how many iterations/length/cells it takes for the path to complete 
        int time = 0;
        // Counting the fresh fruits as there are cases if there is no adjacent rotten fruit, then the answer would be -1
        // This is because the question demands the time taken for ALL the fruits to be rotten
        int fresh = 0;
        
        
        // In a usual case, when we are trying to find the shortest path from top-left to bottom-right, adding [0,0]
        // makes sense, but here any adjacent rotten fruit can make the fresh fruit rotten.
        // There could be a case where the top-left and bottom-right are empty and only in the middle the path needs to
        // be calculated. This is why we are iterating all the grid elements.
        for (int r = 0; r <= ROWS - 1; r++) {
            for (int c = 0; c <= COLS - 1; c++) {
                if (grid[r][c] == 1) {
                    fresh++;
                }
                if (grid[r][c] == 2) {
                    queue.offer(new int[]{r, c});
                }
            }
        }
        
        while (fresh > 0 && !queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i <= size - 1; i++) {
                int[] cell = queue.removeFirst();
                int r = cell[0];
                int c = cell[1];
                
                for (int[] neighbour : neighbours) {
                    int newR = r + neighbour[0];
                    int newC = c + neighbour[1];
                    if (!baseCondition(grid, newR, newC)) {
                        continue;
                    }
                    grid[newR][newC] = 2;
                    queue.add(new int[]{newR, newC});
                    fresh--;
                }
            }
            time++;
        }
        return fresh == 0 ? time : -1;
    }

    private static boolean baseCondition(int[][] grid, int r, int c) {
        final int ROWS = grid.length;
        final int COLUMNS = grid[0].length;
        if (Math.min(r, c) < 0 ||
                (r >= ROWS || c >= COLUMNS) ||
                grid[r][c] == 0 ||
                grid[r][c] == 2
        ) {
            return false;
        }
        return true;
    }
}

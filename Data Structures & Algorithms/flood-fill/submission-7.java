class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        return dfs(image, sr, sc, color, image[sr][sc]);
    }

    private static int[][] dfs(int[][] image, int sr, int sc, int color, int target) {
        if (!baseCondition(image, sr, sc, color, target)) {
            return image;
        }
        // Check 2: Main condition
        image[sr][sc] = color;
        // Check 3: Recurse
        image = dfs(image, sr + 1, sc, color, target);
        image = dfs(image, sr - 1, sc, color, target);
        image = dfs(image, sr, sc + 1, color, target);
        image = dfs(image, sr, sc - 1, color, target);
        return image;
    }

    /*
     * Check 1: Base condition:
     *  1. Cannot ge less than bounds
     *  2. Cannot go over bounds
     *  3. Already visited
     *  4. If not equal to target
     */
    private static boolean baseCondition(int[][] image, int sr, int sc, int color, int target) {
        int rowLen = image.length;
        int colLen = image[0].length;
        if (Math.min(sr, sc) < 0 ||
                sr == rowLen ||
                sc == colLen ||
                image[sr][sc] != target ||
                image[sr][sc] == color
        ) {
            return false;
        }
        return true;
    }
}
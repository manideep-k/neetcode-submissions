class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Target target = new Target(sr, sc, image[sr][sc]);
        return dfs(image, sr, sc, color, new int[image.length][image[0].length], target);
    }

    private static int[][] dfs(int[][] image, int sr, int sc, int color, int[][] visit, Target target) {
        if (!baseCondition(image, sr, sc, color, visit, target)) {
            return image;
        }
        // Check 2: Main condition
        image[sr][sc] = color;
        visit[sr][sc] = 1;
        // Check 3: Recurse
        image = dfs(image, sr + 1, sc, color, visit, target);
        image = dfs(image, sr - 1, sc, color, visit, target);
        image = dfs(image, sr, sc + 1, color, visit, target);
        image = dfs(image, sr, sc - 1, color, visit, target);
        return image;
    }

    /*
     * Check 1: Base condition:
     *  1. Cannot ge less than bounds
     *  2. Cannot go over bounds
     *  3. Already visited
     *  4. If not equal to target
     */
    private static boolean baseCondition(int[][] image, int sr, int sc, int color, int[][] visit, Target target) {
        int rowLen = image.length;
        int colLen = image[0].length;
        if (Math.min(sr, sc) < 0 ||
                sr == rowLen ||
                sc == colLen ||
                visit[sr][sc] == 1 ||
                image[sr][sc] != target.colour ||
                image[sr][sc] == color
        ) {
            return false;
        }
        return true;
    }

    private record Target(int sr, int sc, int colour) {

    }
}
class Solution {
    public int climbStairs(int n) {
        if (n <= 2) {
                return n;
            }
            int prev1 = 2; // F(n-1)
            int prev2 = 1; // F(n-2)
            int current = 0;
            for (int i = 3; i <= n; i++) {
                current = prev1 + prev2;
                prev2 = prev1;
                prev1 = current;
            }
            return current;
    }

    private static int dfs(int n, int i, Map<Integer, Integer> cache) {
        if (i == n) {
            return 1;
        } else if (i > n) {
            return 0;
        }
        if (cache.containsKey(i)) {
            return cache.get(i);
        }
        int dfs1 = dfs(n, i + 1, cache);
        cache.putIfAbsent(i + 1, dfs1);
        int dfs2 = dfs(n, i + 2, cache);
        cache.putIfAbsent(i + 2, dfs2);
        return dfs1 + dfs2;
    }
}

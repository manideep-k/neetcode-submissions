class Solution {
    public int climbStairs(int n) {
        return dfs(n, 0, new HashMap<>());
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

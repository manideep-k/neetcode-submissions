class Solution {
    public int minCostClimbingStairs(int[] cost) {
        // F(i) = min(F(i+1), nums[i} + F(i+2))
        Map<Integer, Integer> cache = new HashMap<>();
        return Math.min(dfs(cost, 0, cache), dfs(cost, 1, cache));
        
    }
    
    private static int dfs(int[] cost, int i, Map<Integer, Integer> cache) {
        if (i >= cost.length) {
            return 0;
        }
        if (cache.containsKey(i)) {
            return cache.get(i);
        }
        int val = cost[i] + Math.min(dfs(cost, i + 1, cache), dfs(cost, i + 2, cache));
        cache.put(i, val);
        return val;
    }
}

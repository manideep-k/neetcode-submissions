class Solution {
    public int rob(int[] nums) {
        return dfs(nums, 0, new HashMap<>());
    }

    private static int dfs(int[] nums, int i, Map<Integer, Integer> cache) {
        if (i >= nums.length) {
            return 0;
        }
        if (cache.containsKey(i)) {
            return cache.get(i);
        }
        int skip = dfs(nums, i + 1, cache);
        int current = nums[i] + dfs(nums, i + 2, cache);
        
        int value = Math.max(skip, current);
        cache.put(i, value);
        return value;
    }
}

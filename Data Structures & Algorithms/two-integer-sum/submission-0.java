class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i]; // 10-4=6, 10-5=5, 10-6=4
            if (map.containsKey(diff)) {
                return new int[]{map.get(diff), i};
            }
            map.put(nums[i], i);        // {4:0, 5:1}
        }
        return new int[]{-1, -1};
    }
}

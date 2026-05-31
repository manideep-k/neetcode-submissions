class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int L = 0;
        Map<Integer, Integer> count = new HashMap<>();
        for (int R = 0; R <= nums.length - 1; R++) {
            if (R - L > k) {
                count.remove(nums[L]);
                L++;
            }
            int num = nums[R];
            count.compute(num, (key, value) -> {
                if (value == null) {
                    value = 0;
                }
                return value + 1;
            });
            if (count.get(num) > 1) {
                return true;
            }
        }
        return false;
    }
}
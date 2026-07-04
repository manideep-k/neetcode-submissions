class Solution {
    public int[] twoSum(int[] nums, int target) {
        int L = 0;
        int R = nums.length - 1;
        while (L < R) {
            int sum = nums[R] + nums[L];
            if (sum == target) {
                return new int[]{L + 1, R + 1};
            } else if (sum > target) {
                R--;
            } else {
                L++;
            }
        }
        return new int[]{-1, -1};
    }
}

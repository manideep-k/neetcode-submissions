class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int total = 0;
        int curMax = 0;
        int maxSum = nums[0];
        int curMin = 0;
        int minSum = nums[0];
        for (int num : nums) {
            if (curMax < 0) {
                curMax = 0;
            }
            if (curMin > 0) {
                curMin = 0;
            }
            curMax = curMax + num;
            maxSum = Math.max(maxSum, curMax);

            curMin = curMin + num;
            minSum = Math.min(minSum, curMin);
            total = total + num;
        }
        if (maxSum < 0) {
            return maxSum;
        }
        return Math.max(maxSum, (total - minSum));
    }
}
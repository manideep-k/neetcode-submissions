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
        // Cicrular array max sum is between maxsum or (total - minsum)
        // The concept here is minsum removes the bad part that contributes to negative results in a subarray
        // Ex: [-2, 4, -5, 4, -5, 9, 4] answer is [9, 4, -2, 4] and it removed the bad part which is middle subarray: [-5, 4, -5] (minSum)
        return Math.max(maxSum, (total - minSum));
    }
}
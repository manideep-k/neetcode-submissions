class Solution {
    public int maxSubArray(int[] nums) {
        int curSum = 0;
        int maxSum = nums[0];
        for (int num : nums) {
            // If curSum is negative, it will never be able to contribute to a maxSum
            // Setting curSum=0 makes it ignore the negative sum sub array and moves forward.
            if (curSum < 0) {
                curSum = 0;
            }
            // Blind add 1: Just add the values blindly, this is so that even if a value is less it can still contribute to maxSum
            curSum = curSum + num;
            // Blind add 2: Just retain the largest value blindly as it should
            maxSum = Math.max(curSum, maxSum);
        }
        return maxSum;
    }
}

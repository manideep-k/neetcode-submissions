class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int cur = 0;
        for (int num : nums) {
            if (num == 1) {
                cur++;
            } else {
                cur = 0;
            }
            max = Math.max(cur, max);
        }
        return max;
    }
}
class Solution {
    public int findMin(int[] nums) {
        int L = 0;
        int R = nums.length - 1;
        int res = nums[0];
        while (L <= R) {
            int mid = L + (R - L) / 2;
            int numL = nums[L];
            int numR = nums[R];
            int numM = nums[mid];
            boolean isL = (numM > numL) && (numM < numR);
            if (isL) {
                return numL;
            } else {
                // Binary search on the right subarray
                res = Math.min(res, numM);
                if (numM < numL) {
                    R = mid - 1;
                } else {
                    L = mid + 1;
                }
            }
        }
        return res;
    }
}

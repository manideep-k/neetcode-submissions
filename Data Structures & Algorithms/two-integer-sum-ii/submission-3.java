class Solution {
    public int[] twoSum(int[] nums, int target) {
        int L = 0;
        int R = nums.length - 1;
        while (L < R) {
            System.out.println("nums[L]: " + nums[L] + ", nums[R]: " + nums[R]);
            int sum = nums[R] + nums[L];
            // If target is sum then we have reached our answer
            if (sum == target) {
                return new int[]{L + 1, R + 1};
            } else if (sum > target) {
                // This is similar to binary search
                // Since this is an sorted array (inc), if sum is more than what is requried
                // We reduce the right index assuming that the (R - 1)th element will either be the same or a lesser element
                R--;
            } else {
                // This is similar to binary search
                // Since this is an sorted array (inc), if sum is less than what is requried
                // We increase the left index assuming that the (L + 1)th element will either be the same or a greated element
                L++;
            }
        }
        // This should never occur, just added it for the compiler.
        return new int[]{-1, -1};
    }
}

class Solution {
    public int pivotIndex(int[] nums) {
        int[] prefix = new int[nums.length];
        int sum = 0;
        for (int i = 0; i <= nums.length - 1; i++) {
            sum = sum + nums[i];
            prefix[i] = sum;
        }
        for (int i = 0; i <= nums.length - 1; i++) {
            
            int left = 0;
            int right = 0;
            if (i == 0) {
                right = prefix[nums.length - 1] - nums[0];
            } else if (i == nums.length - 1) {
                left = prefix[nums.length - 2];
            } else {
                left = prefix[i - 1];
                right = prefix[nums.length - 1] - prefix[i];
            }
            if (i == 2) {
                System.out.println("Prefix : " + Arrays.toString(prefix));
                System.out.println("Right : " + right);
                System.out.println("Left : " + left);
            }
            if (left == right) {
                return i;
            }
        }
        return -1;
    }
}
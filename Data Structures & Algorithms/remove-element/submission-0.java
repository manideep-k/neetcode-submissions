class Solution {
    public int removeElement(int[] nums, int val) {
        int count = 0;
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            /*
             * 0 1 2 2 3 0 4 2
             * *^0=0 1 2 2 3 0 4 2
             * 0 *^1=1 2 2 3 0 4 2
             * 0 1 *^2 2 3 0 4 2
             * 0 1 ^2 *2 3 0 4 2
             * 0 1 ^2=3 2 *3 0 4 2
             * 0 1 3 ^2=0 3 *0 4 2
             * 0 1 3 0 ^3=4 0 *4 2
             * 0 1 3 0 4 ^0 4 *2 
            */
            if (nums[i] != val) {
                count++;
                nums[k] = nums[i];
                k++;
            }
        }
        return count;
    }
}
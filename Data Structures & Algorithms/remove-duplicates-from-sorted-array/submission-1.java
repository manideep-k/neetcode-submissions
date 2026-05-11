class Solution {
    public int removeDuplicates(int[] nums) {
        int val = nums[0];
        int count = 1;
        for (int i = 0; i < nums.length; i++) {
            /*
             * 1 1 2 3 4
             * i=0 | count=1 | val=1
                1 1 2 3 4
             * i=1 | count=1 | val=1
                1 1 2 3 4
             * i=2 | count=2 | val=2
                1 2 2 3 4
             * i=3 | count=3 | val=3
                  
            */
            if (nums[i] > val) {
                val = nums[i];
                nums[count] = nums[i];
                count++;
            }
        }
        return count; 
    }
}
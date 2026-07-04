class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // Need to sort it to make sure we search it using binary search. Our favourite solution for everything :)
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i <= nums.length - 1; i++) {
            // We are skipping duplicate 'i' values because they will produce the same values.
            // For example, nums = [-2, 0, 0, 2, 2]
            // In here if we sort it, that would become [-2, 0, 0, 2, 2]
            // Let's say if i=1 (num=0), then we would want to skip i=2 (num=0) as the value is 0
            // The possible solutions for this are just [-2, 2, 0] no matter which index we choose to put in our i,j & k
            // If we were to skip the below if condition, we will have duplicate values like [-2,2,0], [0,-2,2] etc.
            // and we will have to add expensive list.contains condition which would not be ideal.
            // This would be the same pattern for j and k as well, after sorting adjacent elements which are equal 
            // can be ignored if they are already computed
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = nums[i] * -1;
            int j = i + 1;
            int k = nums.length - 1;
            
            while (j < k) {
                int sum = nums[j] + nums[k];
                if (sum == target) {
                    res.add(List.of(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    // Skip duplicates of j & k
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                    while (j < k && nums[k] == nums[k + 1]) {
                        k--;
                    }
                } else if (sum < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return res;
    }
}

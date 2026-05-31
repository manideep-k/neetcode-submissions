class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int L = 0;
        Set<Integer> window = new HashSet<>();
        for (int R = 0; R <= nums.length - 1; R++) {
            if (R - L > k) {
                window.remove(nums[L]);
                L++;
            }
            int num = nums[R];
            if (window.contains(num)) {
                return true;
            }
            window.add(num);
        }
        return false;
    }
}
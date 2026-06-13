class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> store = new HashMap<>();
    for (int i = 0; i <= nums.length - 1; i++) {
        int num = nums[i];
        if (store.containsKey(num)) {
          int j = store.get(num);
          if (Math.abs(i - j) <= k) {
            return true;
          }
        }
        store.put(num, i);
    }
    return false;
    }
}
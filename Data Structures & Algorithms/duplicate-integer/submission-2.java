class Solution {
    public boolean hasDuplicate(int[] nums) {
        java.util.Set<Integer> hash = new HashSet<>();
        for (int num : nums) {
            hash.add(num);
        }
        return hash.size() != nums.length;
    }
}
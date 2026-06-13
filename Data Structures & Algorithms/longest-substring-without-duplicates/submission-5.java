class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int l = 0;
        int maxLength = 0;
        //a b ^b *a
        for (int r = 0; r < s.length(); r++) {
            Character c = s.charAt(r);
            if (map.containsKey(c)) {
                int oldC = map.get(c);
                l = Math.max(oldC + 1, l);
                // if (s.charAt(oldC + 1) == c) {
                //     l = r;
                // }
            }
            map.put(c, r);
            maxLength = Math.max(maxLength, r - l + 1);
        }
        return maxLength;
    }
}

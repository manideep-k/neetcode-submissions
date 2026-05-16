

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> sHash = new HashMap<>();
        Map<Character, Integer> tHash = new HashMap<>();
        for (char c : s.toCharArray()) {
            sHash.compute(c, (val, count) -> {
                if (count == null) {
                    return 1;
                }
                return count + 1;
            });
        }
        for (char c : t.toCharArray()) {
            tHash.compute(c, (val, count) -> {
                if (count == null) {
                    return 1;
                }
                return count + 1;
            });
        }
        return sHash.equals(tHash);
    }
}

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String hash = getHash(str);
            map.compute(hash, (key, strList) -> {
                if (strList == null) {
                    strList = new ArrayList<>();
                }
                strList.add(str);
                return strList;
            });
        }
        return new ArrayList<>(map.values());
    }

    private String getHash(String s) {
        int[] hash = new int[26];
        Arrays.fill(hash, 0);
        for (char c : s.toCharArray()) {
            int ascii = c - 'a';
            hash[ascii] = hash[ascii] + 1;
        }
        return Arrays.toString(hash);
    }
}

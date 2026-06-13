class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> store = new HashMap<>();
        for (String str : strs) {
            String hash = getHash(str);
            store.compute(hash, (k, v) -> {
                if (v == null) {
                    v = new ArrayList<>();
                }
                v.add(str);
                return v;
            });
        }
        return new ArrayList<>(store.values());
    }

    private String getHash(String s) {
        int[] hash = new int[26];
        Arrays.fill(hash, 0);
        for (Character c : s.toCharArray()) {
            int i = c - 97;
            hash[i]++;
        }
        return Arrays.toString(hash);
    }
}
